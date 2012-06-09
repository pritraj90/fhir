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
package org.hl7.fhir.utilities.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.hl7.fhir.utilities.Utilities;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

public class XhtmlGenerator {

	public void generate(Document doc, File xhtml, String name, String desc) throws Exception {
		FileOutputStream outs = new FileOutputStream(xhtml);
		OutputStreamWriter out = new OutputStreamWriter(outs);
		
		out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n");
		out.write("<head>\r\n");
		out.write(" <title>Example Instance for "+name+"</title>\r\n");
		out.write(" <link rel=\"Stylesheet\" href=\"fhir.css\" type=\"text/css\" media=\"screen\"/>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
    out.write("<p>&nbsp;</p>\r\n");	
    out.write("<div class=\"example\">\r\n");
    out.write("<p>"+Utilities.escapeXml(desc)+"</p>\r\n"); 
    out.write("<pre class=\"xml\">\r\n");

		for (int i = 0; i < doc.getChildNodes().getLength(); i++)
			writeNode(out, doc.getChildNodes().item(i));
		
    out.write("</pre>\r\n");
    out.write("</div>\r\n");
		out.write("</body>\r\n");
		out.write("</html>\r\n");
		out.flush();
		outs.close();
	}

	private void writeNode(OutputStreamWriter out, Node node) throws Exception {
		if (node.getNodeType() == Node.ELEMENT_NODE)
			writeElement(out, (Element) node);
		else if (node.getNodeType() == Node.TEXT_NODE)
			writeText(out, (Text) node);
		else if (node.getNodeType() == Node.COMMENT_NODE)
			writeComment(out, (Comment) node);
		else if (node.getNodeType() == Node.PROCESSING_INSTRUCTION_NODE)
			writeProcessingInstruction(out, (ProcessingInstruction) node);
		else if (node.getNodeType() != Node.ATTRIBUTE_NODE)
			throw new Exception("Unhandled node type");
	}

	private void writeProcessingInstruction(OutputStreamWriter out, ProcessingInstruction node) {
		
		
	}

	private void writeComment(OutputStreamWriter out, Comment node) throws DOMException, IOException {
		out.write("<span class=\"xmlcomment\">&lt;!-- "+node.getTextContent()+" --&gt;</span>");
	}

	private void writeText(OutputStreamWriter out, Text node) throws DOMException, IOException {
		out.write("<b>"+escapeHtml(node.getTextContent())+"</b>");
	}

	private void writeElement(OutputStreamWriter out, Element node) throws Exception {
		out.write("<span class=\"xmltag\">&lt;"+node.getNodeName()+"</span>");
		if (node.hasAttributes()) {
			out.write("<span class=\"xmlattr\">");
			for (int i = 0; i < node.getAttributes().getLength(); i++) {
				out.write(" "+node.getAttributes().item(i).getNodeName()+"=\""+escapeHtml(node.getAttributes().item(i).getTextContent())+"\"");
			}
			out.write("</span>");
	
		}
		if (node.hasChildNodes()) {
			out.write("<span class=\"xmltag\">&gt;</span>");
			for (int i = 0; i < node.getChildNodes().getLength(); i++)
				writeNode(out, node.getChildNodes().item(i));
			
			out.write("<span class=\"xmltag\">&lt;/"+node.getNodeName()+"&gt;</span>");
		}
		else 
			out.write("<span class=\"xmltag\">/&gt;</span>");
	}
	
	private String escapeHtml(String doco) {
		if (doco == null)
			return "";
		
		StringBuilder b = new StringBuilder();
		for (char c : doco.toCharArray()) {
		  if (c == '<')
			  b.append("&lt;");
		  else if (c == '<')
			  b.append("&gt;");
		  else if (c == '&')
			  b.append("&amp;");
		  else if (c == '\t')
			  b.append("  ");
		  else if (c == '\'')
			  b.append("&apos;");
		  else if (c == '"')
			  b.append("&quot;");
		  else 
			  b.append(c);
		}		
		return b.toString();
	}	
}
