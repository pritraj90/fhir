package org.hl7.fhir.instance.formats;

/*
Copyright (c) 2011-2012, HL7, Inc
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


import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import org.hl7.fhir.instance.model.AtomEntry;
import org.hl7.fhir.instance.model.AtomFeed;
import org.hl7.fhir.instance.model.Resource;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xml.IXMLWriter;
import org.hl7.fhir.utilities.xml.XMLWriter;

public class AtomComposer extends XmlBase {
  private IXMLWriter xml;
  private boolean htmlPretty;

  public void compose(OutputStream stream, AtomFeed feed, boolean pretty) throws Exception {
    XMLWriter writer = new XMLWriter(stream, "UTF-8");
    writer.setPretty(pretty);
    writer.start();
    compose(writer, feed, pretty);
    writer.close();
  }
  
  public void compose(OutputStream stream, AtomFeed feed, boolean pretty, boolean htmlPretty) throws Exception {
    XMLWriter writer = new XMLWriter(stream, "UTF-8");
    writer.setPretty(pretty);
    writer.start();
    compose(writer, feed, htmlPretty);
    writer.close();
  }
  
  public void compose(IXMLWriter writer, AtomFeed feed, boolean htmlPretty) throws Exception {
    this.htmlPretty = htmlPretty;
    xml = writer;
    xml.setDefaultNamespace(ATOM_NS);
    composeFeed(feed);
  }

  private void composeFeed(AtomFeed feed) throws Exception {
    xml.open(ATOM_NS, "feed");
    if (feed.getTitle() != null)
      xml.element(ATOM_NS, "title", feed.getTitle());
    if (feed.getUpdated() != null)
      xml.element(ATOM_NS, "updated", new SimpleDateFormat("YYYY-MM-DDTHH:NN:SSZ").format(feed.getUpdated()));
    if (feed.getId() != null)
      xml.element(ATOM_NS, "id", feed.getId());
    if (feed.getLink() != null) {
      xml.attribute("rel", "self");
      xml.attribute("href", feed.getLink());
      xml.element(ATOM_NS, "link", null);
    }
    for (AtomEntry e : feed.getEntryList())
      composeEntry(e);
    xml.close(ATOM_NS, "feed");
  }

  private void composeEntry(AtomEntry e) throws Exception  {
    if (e.getVersionId() != null) {
      xml.namespace(GDATA_NS, "gd");
      xml.attribute(GDATA_NS, "etag", e.getVersionId());
    }
    
    xml.open(ATOM_NS, "entry");
    if (e.getTitle() != null)
      xml.element(ATOM_NS, "title", e.getTitle());
    if (e.getLink() != null) {
      xml.attribute("rel", "self");
      xml.attribute("href", e.getLink());
      xml.element(ATOM_NS, "link", null);
    }
    if (e.getId() != null)
      xml.element(ATOM_NS, "id", e.getId());
    if (e.getUpdated() != null)
      xml.element(ATOM_NS, "updated", dateToXml(e.getUpdated()));
    if (e.getPublished() != null)
      xml.element(ATOM_NS, "published", dateToXml(e.getPublished()));
    xml.open(ATOM_NS, "author");
    if (e.getAuthorName() != null)
      xml.element(ATOM_NS, "name", e.getAuthorName());
    if (e.getAuthorUri() != null)
      xml.element(ATOM_NS, "uri", e.getAuthorUri());
    xml.close(ATOM_NS, "author");
    if (e.getCategory() != null) {      
      xml.attribute("term", e.getCategory());
      xml.attribute("scheme", "http://hl7.org/fhir/sid/fhir/resource-types");
      xml.element(ATOM_NS, "category", null);
    }

    xml.attribute("type", "text/xml");
    xml.open(ATOM_NS, "content");
    new XmlComposer().compose(xml, e.getResource(), htmlPretty);
    xml.close(ATOM_NS, "content");
    
    xml.attribute("type", "xhtml");
    xml.open(ATOM_NS, "summary");
    xml.namespace(XhtmlComposer.XHTML_NS, null);
    boolean oldPretty = xml.isPretty();
    xml.setPretty(htmlPretty);
    new XhtmlComposer().compose(xml, e.getSummary());
    xml.setPretty(oldPretty);
    xml.close(ATOM_NS, "summary");
    
    xml.close(ATOM_NS, "entry");
  }
}
