package org.hl7.fhir.instance.formats;
/*
Copyright (c) 2011-2013, HL7, Inc
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

import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.instance.model.*;
import org.hl7.fhir.instance.model.Boolean;
import org.hl7.fhir.instance.model.Integer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;
import org.xmlpull.v1.XmlPullParser;

public abstract class XmlParserBase extends ParserBase implements Parser {

  private boolean allowUnknownContent;
  public boolean isAllowUnknownContent() {
    return allowUnknownContent;
  }
  public void setAllowUnknownContent(boolean allowUnknownContent) {
    this.allowUnknownContent = allowUnknownContent;
  }
    
  abstract protected Resource parseResource(XmlPullParser xpp) throws Exception;

  /** -- worker routines --------------------------------------------------- */
  
  protected void parseTypeAttributes(XmlPullParser xpp, Type t) throws Exception {
    parseElementAttributes(xpp, t);
  }

  protected void parseElementAttributes(XmlPullParser xpp, Element e) throws Exception {
    if (xpp.getAttributeValue(null, "id") != null) {
      e.setXmlId(xpp.getAttributeValue(null, "id"));
      idMap.put(e.getXmlId(), e);
    }
  }

  protected void parseResourceAttributes(XmlPullParser xpp, Resource r) throws Exception {
    parseElementAttributes(xpp, r);
  }


  private String pathForLocation(XmlPullParser xpp) {
    return xpp.getPositionDescription();
  }
  

  public ResourceOrFeed parseGeneral(InputStream input) throws Exception {
    XmlPullParser xpp = loadXml(input);
    ResourceOrFeed r = new ResourceOrFeed();
    
    if (xpp.getNamespace().equals(FHIR_NS))
      r.resource = parseResource(xpp);
    else if (xpp.getNamespace().equals(ATOM_NS)) 
      r.feed = parseFeed(xpp);
    else
      throw new Exception("This does not appear to be a FHIR resource (wrong namespace '"+xpp.getNamespace()+"') (@ /)");
    return r;    
  }

  public Resource parse(InputStream input) throws Exception {
    XmlPullParser xpp = loadXml(input);
  
    if (!xpp.getNamespace().equals(FHIR_NS))
      throw new Exception("This does not appear to be a FHIR resource (wrong namespace '"+xpp.getNamespace()+"') (@ /)");
    return parseResource(xpp);
  }

  public Resource parse(XmlPullParser xpp) throws Exception {
    if (!xpp.getNamespace().equals(FHIR_NS))
      throw new Exception("This does not appear to be a FHIR resource (wrong namespace '"+xpp.getNamespace()+"') (@ /)");
    return parseResource(xpp);
  }

  
  protected void unknownContent(XmlPullParser xpp) throws Exception {
    if (!isAllowUnknownContent())
      throw new Exception("Unknown Content "+xpp.getName()+" @ "+pathForLocation(xpp));
  }
  
  protected XhtmlNode parseXhtml(XmlPullParser xpp) throws Exception {
    XhtmlParser prsr = new XhtmlParser();
    return prsr.parseHtmlNode(xpp);
  }



  protected Resource parseBinary(XmlPullParser xpp) throws Exception {
    Binary res = new Binary();
    parseElementAttributes(xpp, res);
    res.setContentType(xpp.getAttributeValue(null, "contentType"));
    int eventType = xpp.next();
    if (eventType == XmlPullParser.TEXT) {
      res.setContent(Base64.decodeBase64(xpp.getText().getBytes()));
      eventType = xpp.next();
    }
    if (eventType != XmlPullParser.END_TAG)
      throw new Exception("Bad String Structure");
    xpp.next();
    return res;
  }

  private AtomFeed parseFeed(XmlPullParser xpp) throws Exception {
    if (!xpp.getNamespace().equals(ATOM_NS))
      throw new Exception("This does not appear to be an atom feed (wrong namespace '"+xpp.getNamespace()+"') (@ /)");
    return parseAtom(xpp);
  }

  private AtomFeed parseAtom(XmlPullParser xpp) throws Exception {
    AtomFeed res = new AtomFeed();
    if (!xpp.getName().equals("feed"))
      throw new Exception("This does not appear to be an atom feed (wrong name '"+xpp.getName()+"') (@ /)");
    xpp.next();
    
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("title")) {
        res.setTitle(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id"))
        res.setId(parseString(xpp));
      else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("link")){
        res.getLinks().put(xpp.getAttributeValue(null, "rel"), xpp.getAttributeValue(null, "href"));
        skipEmptyElement(xpp);
      } else if(eventType == XmlPullParser.START_TAG && xpp.getName().equals("updated"))
        res.setUpdated(parseDate(xpp));
      else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("entry"))
        res.getEntryList().add(parseEntry(xpp));
      else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        xpp.next();
        eventType = nextNoWhitespace(xpp);
        while (eventType != XmlPullParser.END_TAG) {
          if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
            res.setAuthorName(parseString(xpp));
          } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("uri"))
            res.setAuthorUri(parseString(xpp));
          else
            throw new Exception("Bad Xml parsing entry.author");
          eventType = nextNoWhitespace(xpp);
        }
        xpp.next();
      }else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("totalResults")){
        res.setTotalResults(parseInt(xpp));
      }
      else
        throw new Exception("Bad Xml parsing Atom Feed");
      eventType = nextNoWhitespace(xpp);
    }

    return res;  
  }

  private AtomEntry parseEntry(XmlPullParser xpp) throws Exception {
    AtomEntry res = new AtomEntry();
    
    xpp.next();    
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("title")) {
        res.setTitle(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id"))
        res.setId(parseString(xpp));
      else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("link")) {
        res.getLinks().put(xpp.getAttributeValue(null, "rel"), xpp.getAttributeValue(null, "href"));
        skipEmptyElement(xpp);
      } else if(eventType == XmlPullParser.START_TAG && xpp.getName().equals("updated"))
        res.setUpdated(parseDate(xpp));
      else if(eventType == XmlPullParser.START_TAG && xpp.getName().equals("published"))
        res.setPublished(parseDate(xpp));
      else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("category")) {
        if ("http://hl7.org/fhir/tag".equals(xpp.getAttributeValue(null, "scheme"))) 
          res.getTags().put(xpp.getAttributeValue(null, "term"), xpp.getAttributeValue(null, "label"));
        skipEmptyElement(xpp);
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        xpp.next();
        eventType = nextNoWhitespace(xpp);
        while (eventType != XmlPullParser.END_TAG) {
          if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
            res.setAuthorName(parseString(xpp));
          } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("uri"))
            res.setAuthorUri(parseString(xpp));
          else
            throw new Exception("Bad Xml parsing entry.author");
          eventType = nextNoWhitespace(xpp);
        }
        xpp.next();
      }
      else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("content")) {
        xpp.next();
        nextNoWhitespace(xpp);
        XmlParser p = new XmlParser();
        res.setResource(p.parse(xpp));
        xpp.next();
        nextNoWhitespace(xpp);
        xpp.next();
        
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("summary")) {
        xpp.next();
        nextNoWhitespace(xpp);
        res.setSummary(new XhtmlParser().parseHtmlNode(xpp));
        xpp.next();
        nextNoWhitespace(xpp);
        xpp.next();
      } else
        throw new Exception("Bad Xml parsing entry");
      eventType = nextNoWhitespace(xpp);
    }

    xpp.next();
    return res;  
  }

  private String parseString(XmlPullParser xpp) throws Exception {
    String res = null;
    if (xpp.next() == XmlPullParser.TEXT) {
      res = xpp.getText();
      if (xpp.next() != XmlPullParser.END_TAG)
        throw new Exception("Bad String Structure");
    }
    xpp.next();
    return res;
  }
  
  private int parseInt(XmlPullParser xpp) throws Exception {
    int res = -1;
    String textNode = parseString(xpp);
    res = java.lang.Integer.parseInt(textNode);
    return res;
  }
  
  private Calendar parseDate(XmlPullParser xpp) throws Exception {
    return xmlToDate(parseString(xpp));    
  }

 
}
