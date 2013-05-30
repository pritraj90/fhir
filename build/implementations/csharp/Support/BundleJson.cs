﻿/*
  Copyright (c) 2011-2012, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  

*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using Hl7.Fhir.Model;
using System.Xml.Linq;
using Hl7.Fhir.Parsers;
using System.IO;
using Hl7.Fhir.Serializers;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace Hl7.Fhir.Support
{
    public static class BundleJson
    {
        private const string JATOM_VERSION = "version";
        private const string JATOM_DELETED = "deleted";

        private static int? intValueOrNull(JToken attr)
        {
            if (attr == null) return null;

            return attr.Value<int?>();
        }

        private static Uri uriValueOrNull(JToken attr)
        {
            if (attr == null) return null;

            var value = attr.Value<string>();

            return String.IsNullOrEmpty(value) ? null : new Uri(value, UriKind.RelativeOrAbsolute);
        }

        private static DateTimeOffset? instantOrNull(JToken attr)
        {
            if (attr == null) return null;

            return attr.Value<DateTimeOffset?>();

            //return String.IsNullOrEmpty(value) ? (DateTimeOffset?)null :
            //    Util.ParseIsoDateTime(value);
        }

        internal static Bundle Load(JsonReader reader, ErrorList errors)
        {
            JObject feed;
            reader.DateParseHandling = DateParseHandling.DateTimeOffset;

            try
            {
                feed = JObject.Load(reader);
            }
            catch (Exception exc)
            {
                errors.Add("Exception while loading feed: " + exc.Message);
                return null;
            }

            Bundle result;

            try
            {
                result = new Bundle()
                {
                    Title = feed.Value<string>(BundleXml.XATOM_TITLE),
                    LastUpdated = instantOrNull(feed[BundleXml.XATOM_UPDATED]),
                    Id = uriValueOrNull(feed[BundleXml.XATOM_ID]),
                    Links = getLinks(feed[BundleXml.XATOM_LINK]),
                    AuthorName = feed[BundleXml.XATOM_AUTHOR] as JArray != null ?
                                feed[BundleXml.XATOM_AUTHOR]
                                    .Select(auth => auth.Value<string>(BundleXml.XATOM_AUTH_NAME))
                                    .FirstOrDefault()
                                : null,
                    AuthorUri = feed[BundleXml.XATOM_AUTHOR] as JArray != null ?
                                feed[BundleXml.XATOM_AUTHOR]
                                    .Select(auth => auth.Value<string>(BundleXml.XATOM_AUTH_URI))
                                    .FirstOrDefault() : null,
                    TotalResults = intValueOrNull(feed[BundleXml.XATOM_TOTALRESULTS])
                };
            }
            catch (Exception exc)
            {
                errors.Add("Exception while parsing json feed attributes: " + exc.Message,
                    String.Format("Feed '{0}'", feed.Value<string>(BundleXml.XATOM_ID)));
                return null;
            }

            var entries = feed[BundleXml.XATOM_ENTRY];
            if (entries != null)
            {
                if (!(entries is JArray))
                {
                    errors.Add("The json feed contains a single entry, instead of an array");
                    return null;
                }

                result.Entries = loadEntries((JArray)entries, result, errors);
            }

            errors.AddRange(result.Validate());

            return result;
        }

        internal static Bundle Load(string json, ErrorList errors)
        {
            return Load(Util.JsonReaderFromString(json), errors);
        }


        private static ManagedEntryList loadEntries(JArray entries, Bundle parent, ErrorList errors)
        {
            var result = new ManagedEntryList(parent);

            foreach (var entry in entries)
            {
                result.Add(loadEntry(entry, errors));
            }

            return result;
        }

        internal static BundleEntry LoadEntry(string json, ErrorList errors)
        {
            return LoadEntry(Util.JsonReaderFromString(json), errors);
        }

        internal static BundleEntry LoadEntry(JsonReader reader, ErrorList errors)
        {
            JObject entry;
            reader.DateParseHandling = DateParseHandling.DateTimeOffset;

            try
            {
                entry = JObject.Load(reader);
            }
            catch (Exception exc)
            {
                errors.Add("Exception while loading entry: " + exc.Message);
                return null;
            }

            return loadEntry(entry, errors);
        }


        private static BundleEntry loadEntry(JToken entry, ErrorList errors)
        {
            BundleEntry result;

            errors.DefaultContext = "An atom entry";

            try
            {
                string category = getCategoryFromEntry(entry);

                if (entry.Value<DateTimeOffset?>(JATOM_DELETED) != null)
                    result = new DeletedEntry();
                else if (category == BundleXml.XATOM_CONTENT_BINARY)
                    result = new BinaryEntry();
                else
                    result = new ResourceEntry();

                result.Id = uriValueOrNull(entry[BundleXml.XATOM_ID]);
                if (result.Id != null) errors.DefaultContext = String.Format("Entry '{0}'", result.Id.ToString());

                result.Links = getLinks(entry[BundleXml.XATOM_LINK]);

                if (result is DeletedEntry)
                    ((DeletedEntry)result).When = instantOrNull(entry[JATOM_DELETED]);
                else
                {
                    ContentEntry ce = (ContentEntry)result;

                    ce.Title = entry.Value<string>(BundleXml.XATOM_TITLE);
                    ce.LastUpdated = instantOrNull(entry[BundleXml.XATOM_UPDATED]);
                    ce.Published = instantOrNull(entry[BundleXml.XATOM_PUBLISHED]);
                    ce.EntryAuthorName = entry[BundleXml.XATOM_AUTHOR] as JArray != null ?
                        entry[BundleXml.XATOM_AUTHOR]
                            .Select(auth => auth.Value<string>(BundleXml.XATOM_AUTH_NAME))
                            .FirstOrDefault() : null;
                    ce.EntryAuthorUri = entry[BundleXml.XATOM_AUTHOR] as JArray != null ?
                        entry[BundleXml.XATOM_AUTHOR]
                            .Select(auth => auth.Value<string>(BundleXml.XATOM_AUTH_URI))
                            .FirstOrDefault() : null;

                    var content = entry[BundleXml.XATOM_CONTENT];

                    if (content != null)
                    {
                        if (result is ResourceEntry)
                            ((ResourceEntry)ce).Content = getContents(content, errors);
                        else
                        {
                            BinaryEntry be = (BinaryEntry)result;
                            be.Content = getBinaryContents(content, out be.MediaType, errors);
                        }
                    }
                }
            }
            catch (Exception exc)
            {
                errors.Add("Exception while reading entry: " + exc.Message);
                return null;
            }
            finally
            {
                errors.DefaultContext = null;
            }

            return result;
        }

        private static string getCategoryFromEntry(JToken entry)
        {
            return entry[BundleXml.XATOM_CATEGORY] as JArray != null ?
               entry[BundleXml.XATOM_CATEGORY]
                .Where(cat => cat.Value<string>(BundleXml.XATOM_CAT_SCHEME) == BundleXml.ATOM_CATEGORY_RESOURCETYPE_NS)
                .Select(scat => scat.Value<string>(BundleXml.XATOM_CAT_TERM))
                .FirstOrDefault() : null;
        }

        private static UriLinkList getLinks(JToken token)
        {
            var result = new UriLinkList();
            var links = token as JArray;

            if (links != null)
            {
                foreach (var link in links)
                {
                    var uri = uriValueOrNull(link[BundleXml.XATOM_LINK_HREF]);

                    if (uri != null)
                        result.Add(new UriLinkEntry
                        {
                            Rel = link.Value<string>(BundleXml.XATOM_LINK_REL),
                            Uri = uri
                        });
                }
            }

            return result;
        }

        private static Resource getContents(JToken token, ErrorList errors)
        {
            //TODO: This is quite inefficient. The Json parser has just parsed this
            //entry's Resource from json, now we are going to serialize it to as string
            //just to read from it again using a JsonTextReader. But that is what my
            //parser takes as input, so no choice for now...
            string contents = token.ToString();
            JsonTextReader r = new JsonTextReader(new StringReader(contents));
            return FhirParser.ParseResource(new JsonFhirReader(r), errors);
        }

        private static byte[] getBinaryContents(JToken entryContent, out string mediaType, ErrorList errors)
        {
            JToken binaryObject = entryContent[BundleXml.XATOM_CONTENT_BINARY];
            mediaType = null;

            if (binaryObject == null)
            {
                errors.Add("Binary entries must contain an element Binary");
                return null;
            }

            mediaType = binaryObject.Value<string>(BundleXml.XATOM_CONTENT_BINARY_TYPE);

            if (mediaType == null)
            {
                errors.Add("Binary entries must contain a Binary element with a contentType attribute");
                return null;
            }

            JToken binaryContent = binaryObject[BundleXml.XATOM_CONTENT];

            try
            {
                if (binaryContent != null)
                    return Convert.FromBase64String(binaryContent.ToString());
                else
                    return null;
            }
            catch (Exception e)
            {
                errors.Add("Cannot parse content of Binary: " + e.Message);
                return null;
            }
        }

        public static void WriteTo(this Bundle bundle, JsonWriter writer)
        {
            if (bundle == null) throw new ArgumentException("Bundle cannot be null");

            JObject result = new JObject();

            if (!String.IsNullOrWhiteSpace(bundle.Title))
                result.Add(new JProperty(BundleXml.XATOM_TITLE, bundle.Title));
            if (Util.UriHasValue(bundle.Id)) result.Add(new JProperty(BundleXml.XATOM_ID, bundle.Id));
            if (bundle.LastUpdated != null) 
                result.Add(new JProperty(BundleXml.XATOM_UPDATED, bundle.LastUpdated));

            if (!String.IsNullOrWhiteSpace(bundle.AuthorName))
                result.Add(jsonCreateAuthor(bundle.AuthorName, bundle.AuthorUri));
            if (bundle.TotalResults != null) result.Add(new JProperty(BundleXml.XATOM_TOTALRESULTS, bundle.TotalResults.ToString()));
            if (bundle.Links.Count > 0)
                result.Add(new JProperty(BundleXml.XATOM_LINK, jsonCreateLinkArray(bundle.Links)));

            var entryArray = new JArray();

            foreach (var entry in bundle.Entries)
                entryArray.Add(createEntry(entry));

            result.Add(new JProperty(BundleXml.XATOM_ENTRY, entryArray));

            result.WriteTo(writer);
        }


        public static string ToJson(this Bundle bundle)
        {
            if (bundle == null) throw new ArgumentException("Bundle cannot be null");   

            StringBuilder resultBuilder = new StringBuilder();
            StringWriter sw = new StringWriter(resultBuilder);
            JsonWriter jw = new JsonTextWriter(sw);
            WriteTo(bundle, jw);
            jw.Flush();
            jw.Close();

            return resultBuilder.ToString();
        }


        public static byte[] ToJsonBytes(this Bundle bundle)
        {
            if (bundle == null) throw new ArgumentException("Bundle cannot be null"); 

            return Encoding.UTF8.GetBytes(bundle.ToJson());
        }


        public static void WriteTo(this BundleEntry entry, JsonWriter writer)
        {
            if (entry == null) throw new ArgumentException("Entry cannot be null");

            var result = createEntry(entry);

            result.WriteTo(writer);
        }

        public static string ToJson(this BundleEntry entry)
        {
            if (entry == null) throw new ArgumentException("Entry cannot be null");

            StringBuilder resultBuilder = new StringBuilder();
            StringWriter sw = new StringWriter(resultBuilder);
            JsonWriter jw = new JsonTextWriter(sw);
            WriteTo(entry, jw);
            jw.Flush();
            jw.Close();

            return resultBuilder.ToString();
        }


        public static byte[] ToJsonBytes(this BundleEntry entry)
        {
            if (entry == null) throw new ArgumentException("Entry cannot be null");

            return Encoding.UTF8.GetBytes(entry.ToJson());
        }


        private static JObject createEntry(BundleEntry entry)
        {
            if (entry is ContentEntry)
                return createContentEntry((ContentEntry)entry);
            else if (entry is DeletedEntry)
                return createDeletedEntry((DeletedEntry)entry);
            else
                throw new ArgumentException("Don't know how to serialize an entry of type " + entry.GetType().ToString());
        }


        private static JObject createDeletedEntry(DeletedEntry entry)
        {
            JObject newItem = new JObject();

            if(entry.When !=null)
                newItem.Add(new JProperty(JATOM_DELETED, entry.When));
            
            if(Util.UriHasValue(entry.Id))
                newItem.Add(new JProperty(BundleXml.XATOM_ID, entry.Id.ToString()));

            if (Util.UriHasValue(entry.Links.SelfLink))
                newItem.Add(new JProperty(BundleXml.XATOM_LINK,
                        new JArray(jsonCreateLink(Util.ATOM_LINKREL_SELF, entry.Links.SelfLink))));

            return newItem;
        }


        private static JObject createContentEntry(ContentEntry entry)
        {
            //Note: this handles both BinaryEntry and ResourceEntry

            JObject newItem = new JObject();

            if (!String.IsNullOrEmpty(entry.Title)) newItem.Add(new JProperty(BundleXml.XATOM_TITLE, entry.Title));
            if (Util.UriHasValue(entry.Id)) newItem.Add(new JProperty(BundleXml.XATOM_ID, entry.Id.ToString()));

            if (entry.LastUpdated != null) newItem.Add(new JProperty(BundleXml.XATOM_UPDATED, entry.LastUpdated));
            if (entry.Published != null) newItem.Add(new JProperty(BundleXml.XATOM_PUBLISHED, entry.Published));

            if (!String.IsNullOrWhiteSpace(entry.EntryAuthorName))
                newItem.Add(jsonCreateAuthor(entry.EntryAuthorName, entry.EntryAuthorUri));

            if (entry.Links.Count > 0)
                newItem.Add(new JProperty(BundleXml.XATOM_LINK, jsonCreateLinkArray(entry.Links)));

            if (entry is ResourceEntry)
            {
                ResourceEntry re = (ResourceEntry)entry;

                if (re.Content != null)
                {
                    newItem.Add(new JProperty(BundleXml.XATOM_CATEGORY, new JArray(jsonCreateCategory(re.ResourceType))));
                    newItem.Add(new JProperty(BundleXml.XATOM_CONTENT, getContentsAsJObject(re.Content)));
                }
            }
            else if (entry is BinaryEntry)
            {
                BinaryEntry be = (BinaryEntry)entry;

                newItem.Add(new JProperty(BundleXml.XATOM_CATEGORY, new JArray(jsonCreateCategory(BundleXml.XATOM_CONTENT_BINARY))));

                if (be.Content != null)
                {
                    newItem.Add(new JProperty(BundleXml.XATOM_CONTENT, new JObject(
                            new JProperty(BundleXml.XATOM_CONTENT_BINARY, new JObject(
                                new JProperty(BundleXml.XATOM_CONTENT_BINARY_TYPE, be.MediaType),
                                new JProperty(BundleXml.XATOM_CONTENT, Convert.ToBase64String(be.Content)))))));
                }
            }
            else
                throw new NotSupportedException("Cannot serialize unknown entry type " + entry.GetType().Name);

            // Note: this is a read-only property, so it is serialized but never parsed
            if (entry.Summary != null)
                newItem.Add(new JProperty(BundleXml.XATOM_SUMMARY, entry.Summary));

            return newItem;
        }

        private static JProperty jsonCreateAuthor(string name, string uri)
        {
            JObject author = new JObject();

            if (!String.IsNullOrEmpty(name))
                author.Add(new JProperty(BundleXml.XATOM_AUTH_NAME, name));
            if (!String.IsNullOrWhiteSpace(uri))
                author.Add(new JProperty(BundleXml.XATOM_AUTH_URI, uri));

            return new JProperty(BundleXml.XATOM_AUTHOR, new JArray(author));
        }

        private static JObject jsonCreateCategory(string category)
        {
            return new JObject(new JProperty(BundleXml.XATOM_CAT_TERM, category),
                                new JProperty(BundleXml.XATOM_CAT_SCHEME, BundleXml.ATOM_CATEGORY_RESOURCETYPE_NS));
        }

        private static JArray jsonCreateLinkArray(UriLinkList links)
        {
            var result = new JArray();

            foreach (var l in links)
                if (l.Uri != null)
                    result.Add(jsonCreateLink(l.Rel, l.Uri));

            return result;
        }

        private static JObject jsonCreateLink(string rel, Uri link)
        {
            return new JObject(
                new JProperty(BundleXml.XATOM_LINK_REL, rel),
                new JProperty(BundleXml.XATOM_LINK_HREF, link.ToString()));
        }

        private static JObject getContentsAsJObject(Resource resource)
        {
            StringWriter w = new StringWriter();

            //TODO: This would be much more efficient if we could serialize
            //the resource to a JObject directly
            FhirSerializer.SerializeResource(resource, new JsonTextWriter(w));

            JsonTextReader reader = Util.JsonReaderFromString(w.ToString());
            reader.DateParseHandling = DateParseHandling.None;
            return JObject.Load(reader);
        }




    }
}