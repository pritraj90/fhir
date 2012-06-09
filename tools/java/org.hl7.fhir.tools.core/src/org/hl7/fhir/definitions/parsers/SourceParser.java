package org.hl7.fhir.definitions.parsers;
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
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.DefinedStringPattern;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.EventDefn;
import org.hl7.fhir.definitions.model.PrimitiveType;
import org.hl7.fhir.definitions.model.ProfileDefn;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.definitions.model.TypeRef;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.XLSXmlParser;
import org.hl7.fhir.utilities.XLSXmlParser.Sheet;

/**
 * This class parses the master source for FHIR into a single definitions object model
 * 
 * The class knows where to find things, and what order to load them in
 * 
 * @author Grahame
 *
 */
public class SourceParser {

  private Logger logger;
  private IniFile ini;
  private Definitions definitions;
  private String srcDir;
  private String sndBoxDir;
  private String imgDir;
  private String termDir;
  public String dtDir;
  private Map<String, String> csvSrcs;
  private String rootDir;
    
  public SourceParser(Logger logger, String root, Definitions definitions) {
    csvSrcs = new HashMap<String, String>();
    this.logger = logger;

    this.definitions = definitions;    
    
    char sl = File.separatorChar;
    srcDir = root+sl+"source"+sl;
    sndBoxDir = root+sl+"sandbox"+sl;
    ini = new IniFile(srcDir+ "fhir.ini");
    
    termDir = srcDir+"terminologies"+sl;
    dtDir = srcDir+"datatypes"+sl;
    imgDir = root+sl+"images"+sl;
    rootDir = root+sl;
  }

  
  public void parse(boolean isInternalRun) throws Exception {
    logger.log("Loading");
    loadConceptDomains();
    loadPrimitives();

    for (String n : ini.getPropertyNames("types")) 
      loadDataType(n, definitions.getTypes());
    for (String n : ini.getPropertyNames("structures")) 
      loadDataType(n, definitions.getStructures());
    for (String n : ini.getPropertyNames("infrastructure")) 
      loadDataType(n, definitions.getInfrastructure());
    for (String n : ini.getPropertyNames("resources"))  
      loadResource(n, definitions.getResources(), false);
    if (isInternalRun)
      for (String n : ini.getPropertyNames("sandbox")) 
        loadResource(n, definitions.getResources(), true);
    for (String n : ini.getPropertyNames("special-resources")) 
      definitions.getSpecialResources().add(n);
    for (String n : ini.getPropertyNames("future-resources")) {
      DefinedCode cd = new DefinedCode(ini.getStringProperty("future-resources", n), "Yet to be defined", n);
      definitions.getKnownResources().put(n, cd);
      definitions.getFutureResources().put(n, cd);
    }
    
    for (String n : ini.getPropertyNames("profiles")) {
      loadProfile(n, definitions.getProfiles());
    }
  }


  private void loadProfile(String n, Map<String, ProfileDefn> profiles) throws Exception {
    File spreadsheet = new File(rootDir+ini.getStringProperty("profiles", n));
    SpreadsheetParser sparser = new SpreadsheetParser(new FileInputStream(spreadsheet), spreadsheet.getName(), definitions, srcDir);
    ProfileDefn profile = sparser.parseProfile(definitions);
    definitions.getProfiles().put(n, profile);
  }


  private void loadConceptDomains() throws Exception {
    logger.log("Load Concept Domains");
    BindingsParser parser = new BindingsParser(new FileInputStream(new File(termDir+"bindings.xml")), termDir+"bindings.xml", srcDir);
    List<BindingSpecification> cds = parser.parse();
    for (BindingSpecification cd : cds)
    definitions.getBindings().put(cd.getName(), cd);
    
    for (BindingSpecification cd : definitions.getBindings().values()) {
      if (cd.getBinding() == BindingSpecification.Binding.CodeList) {
        File file = new File(termDir+cd.getReference().substring(1)+".csv");
        if (!file.exists())
          throw new Exception("code source file not found for "+cd.getName()+": "+file.getAbsolutePath());
        CodeListParser cparser = new CodeListParser(new FileInputStream(file));
        cparser.parse(cd.getCodes());
      }
    }

  }

  private void loadPrimitives() throws Exception {
    XLSXmlParser xls = new XLSXmlParser(new FileInputStream(dtDir+"primitives.xml"), "primitives");
    Sheet sheet = xls.getSheets().get("Imports");
    for (int row = 0; row < sheet.rows.size(); row++) {
      processImport(sheet, row);
    }
    sheet = xls.getSheets().get("String Patterns");
    for (int row = 0; row < sheet.rows.size(); row++) {
      processStringPattern(sheet, row);
    }
  }

  
  private void processImport(Sheet sheet, int row) throws Exception {
    PrimitiveType prim = new PrimitiveType();
    prim.setCode(sheet.getColumn(row, "Data Type"));
    prim.setDefinition(sheet.getColumn(row, "Definition"));
    prim.setComment(sheet.getColumn(row, "Comments"));
    prim.setSchemaType(sheet.getColumn(row, "Schema"));
    TypeRef td = new TypeRef();
    td.setName(prim.getCode());
    definitions.getKnownTypes().add(td);
    definitions.getPrimitives().put(prim.getCode(), prim);    
  }

  private void processStringPattern(Sheet sheet, int row) throws Exception {
    DefinedStringPattern prim = new DefinedStringPattern();
    prim.setCode(sheet.getColumn(row, "Data Type"));
    prim.setDefinition(sheet.getColumn(row, "Definition"));
    prim.setComment(sheet.getColumn(row, "Comments"));
    prim.setRegex(sheet.getColumn(row, "RegEx"));
    TypeRef td = new TypeRef();
    td.setName(prim.getCode());
    definitions.getKnownTypes().add(td);
    definitions.getPrimitives().put(prim.getCode(), prim);    
  }


  private void loadDataType(String n, Map<String, ElementDefn> map) throws Exception {
    TypeParser tp = new TypeParser();
    List<TypeRef> ts = tp.parse(n);
    definitions.getKnownTypes().addAll(ts);

    TypeRef t = ts.get(0);
    File csv = new File(dtDir+t.getName()+".xml");
    if (csv.exists()) {
      SpreadsheetParser p = new SpreadsheetParser(new FileInputStream(csv), csv.getName(), definitions, srcDir);
      ElementDefn el = p.parseType();
      map.put(t.getName(), el);
    } else {
      String p = ini.getStringProperty("types", n);
      csv = new File(dtDir+p+".xml");
      if (!csv.exists()) 
        throw new Exception("unable to find a definition for "+n+" in "+p);
      XLSXmlParser xls = new XLSXmlParser(new FileInputStream(csv), csv.getAbsolutePath());
      Sheet sheet = xls.getSheets().get("Restrictions");
      boolean found = false;
      for (int i = 0; i < sheet.rows.size(); i++) {
        if (sheet.getColumn(i, "Name").equals(n)) {
          found = true;
          definitions.getConstraints().put(n, 
        		  new DefinedCode(n, sheet.getColumn(i, "Rules"), p));
        }
      }
      if (!found)
        throw new Exception("Unable to find definition for "+n);
    }
  }

  private void loadResource(String n, Map<String, ResourceDefn> map, boolean sandbox) throws Exception {
    String src = sandbox ? sndBoxDir : srcDir;
    File spreadsheet = new File((sandbox ? sndBoxDir : srcDir)+n+File.separatorChar+n+"-spreadsheet.xml");
    if (!spreadsheet.exists()) 
      spreadsheet = new File((sandbox ? sndBoxDir : srcDir)+n+File.separatorChar+n+"-def.xml");
      
    SpreadsheetParser sparser = new SpreadsheetParser(new FileInputStream(spreadsheet), spreadsheet.getName(), definitions, src);
    ResourceDefn root = sparser.parseResource();
    root.setSandbox(sandbox);
    definitions.getKnownResources().put(root.getName(), new DefinedCode(root.getName(), root.getDefinition(), n));
    definitions.getResources().put(root.getName(), root);
    for (EventDefn e : sparser.getEvents())
      processEvent(e, root);
    map.put(root.getName(), root);
    root.setStatus(ini.getStringProperty("status", n));
  }


  private void processEvent(EventDefn defn, ElementDefn root) throws Exception {
    // first, validate the event. The Request Resource needs to be this resource - for now
//    if (!defn.getUsages().get(0).getRequestResources().get(0).equals(root.getName())) 
//      throw new Exception("Event "+defn.getCode()+" has a mismatched request resource - should be "+root.getName()+", is "+defn.getUsages().get(0).getRequestResources().get(0));
    if (definitions.getEvents().containsKey(defn.getCode())) {
      EventDefn master = definitions.getEvents().get(defn.getCode());
      master.getUsages().add(defn.getUsages().get(0));
      if (!defn.getDefinition().startsWith("(see"))
        master.setDefinition(defn.getDefinition());
    } else
      definitions.getEvents().put(defn.getCode(), defn);
  }


  public void checkConditions(List<String> errors) throws Exception {
    Utilities.checkFolder(srcDir, errors);
    Utilities.checkFolder(termDir, errors);
    Utilities.checkFolder(imgDir, errors);
    Utilities.checkFile("required", termDir, "bindings.xml", errors);
    Utilities.checkFile("required", dtDir, "primitives.xml", errors);

    for (String n : ini.getPropertyNames("types"))
      if (ini.getStringProperty("types", n).equals("")) {
        TypeRef t = new TypeParser().parse(n).get(0);
        Utilities.checkFile("type definition", dtDir, t.getName()+".xml", errors);
      }
    for (String n : ini.getPropertyNames("structures"))
      Utilities.checkFile("structure definition", dtDir, n+".xml", errors);
    for (String n : ini.getPropertyNames("infrastructure"))
      Utilities.checkFile("infrastructure definition", dtDir, n+".xml", errors);
    
    for (String n : ini.getPropertyNames("resources")) {
      if (new File(srcDir+n+File.separatorChar, n+"-spreadsheet.xml").exists())
        Utilities.checkFile("definition", srcDir+n+File.separatorChar, n+"-spreadsheet.xml", errors);
      else
        Utilities.checkFile("definition", srcDir+n+File.separatorChar, n+"-def.xml", errors);
      Utilities.checkFile("example xml", srcDir+n+File.separatorChar, n+"-example.xml", errors);
      Utilities.checkFile("resource uml", imgDir, n+".png", errors);    
    }
    for (String n : ini.getPropertyNames("special-resources")) {
      if (new File(srcDir+n+File.separatorChar, n+"-spreadsheet.xml").exists())
        Utilities.checkFile("definition", srcDir+n+File.separatorChar, n+"-spreadsheet.xml", errors);
      else
        Utilities.checkFile("definition", srcDir+n+File.separatorChar, n+"-def.xml", errors);
      Utilities.checkFile("resource uml", imgDir, n+".png", errors);    
    }

  }

}
