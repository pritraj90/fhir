package org.hl7.fhir.tools.publisher.implementations;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.definitions.ecore.fhir.BindingDefn;
import org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.NameScope;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.tools.publisher.PlatformGenerator;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.ZipGenerator;

public class CSharpGenerator extends BaseGenerator implements PlatformGenerator {

	public void generate(Definitions definitions, String destDir,
			String implDir, String version, Date genDate, Logger logger)
			throws Exception {

		throw new UnsupportedOperationException("The C# generator uses eCore, not ElementDefn-style definition.");
	}

	public String getName() {
		return "csharp";
	}

	public String getDescription() {
		return "Resource definitions (+ more todo)";
	}

	public String getTitle() {
		return "C#";
	}

	public boolean isECoreGenerator() {
		return true;
	}

	public void generate(org.hl7.fhir.definitions.ecore.fhir.Definitions definitions, String destDir,
			String implDir, Logger logger) throws Exception {
	
		char sl = File.separatorChar;
		String modelDir = "Model" + sl;
		String parsersDir = "Parsers" + sl;

		
		File f = new File(implDir + modelDir);	if( !f.exists() ) f.mkdir();
		File p = new File(implDir + parsersDir);	if( !p.exists() ) p.mkdir();
		
		List<String> generatedFilenames = new ArrayList<String>();
		{
			String enumsFilename = modelDir + "Bindings.cs";
		
			new CSharpResourceGenerator()
				.generateGlobalEnums(definitions.getBindings(),definitions).toFile(implDir+enumsFilename);						 
			generatedFilenames.add(enumsFilename);
		}

		{
			String primFilename = modelDir + "Primitives.cs";
			 new CSharpPrimitiveGenerator()
			 	.generatePrimitives(definitions.getPrimitives(),definitions).toFile(implDir+primFilename);						 
			generatedFilenames.add(primFilename);
		}

		{
			String primFilename = parsersDir + "XmlPrimitiveParser.cs";
			 new CSharpPrimitiveParserGenerator()
			 	.generatePrimitiveParser(definitions.getPrimitives(),definitions).toFile(implDir+primFilename);						 
			generatedFilenames.add(primFilename);
		}
		
		List<CompositeTypeDefn> allComplexTypes = new ArrayList<CompositeTypeDefn>();
		allComplexTypes.addAll(definitions.getLocalCompositeTypes());
		allComplexTypes.addAll(definitions.getLocalResources());
		
		for( CompositeTypeDefn composite : allComplexTypes )
		{		
			String compositeFilename = modelDir + composite.getName() + ".cs";			
			new CSharpResourceGenerator()
				.generateComposite(composite, definitions).toFile(implDir+compositeFilename);			
			generatedFilenames.add(compositeFilename);
		}

		for( CompositeTypeDefn composite : allComplexTypes )
		{		
			String compositeFilename = parsersDir + "Xml" + composite.getName() + "Parser.cs";			
			new CSharpResourceParserGenerator()
				.generateCompositeParser(composite, definitions).toFile(implDir+compositeFilename);			
			generatedFilenames.add(compositeFilename);
		}
		
		for( ConstrainedTypeDefn constrained : definitions.getLocalConstrainedTypes() )
		{
			String constrainedFilename = modelDir + constrained.getName() + ".cs";
			new CSharpResourceGenerator()
				.generateConstrained(constrained, definitions).toFile(implDir+constrainedFilename);						 
			generatedFilenames.add(constrainedFilename);
		}

		// Collect all bindings to generate the EnumHelper class
		List<BindingDefn> allBindings = new ArrayList<BindingDefn>();
		allBindings.addAll(definitions.getBindings());
		for( NameScope ns : definitions.getLocalCompositeTypes() )
			allBindings.addAll(ns.getBindings());
		for( NameScope ns : definitions.getLocalResources() )
			allBindings.addAll(ns.getBindings());
		{
			String enumHelperFilename = modelDir + "EnumHelper.cs";
			
			new CSharpEnumHelperGenerator()
				.generateEnumHelper(definitions, allBindings).toFile(implDir+enumHelperFilename);						 
			generatedFilenames.add(enumHelperFilename);			
		}
		
		// Generate resource parser entrypoint
		{
			String filename = parsersDir + "XmlResourceParser.cs";
			
			new CSharpResourceParserGenerator()
				.generateResourceParser(definitions).toFile(implDir+filename);						 
			generatedFilenames.add(filename);			
		}
		
		
	    // Generate C# project file
	    CSharpProjectGenerator projGen = new CSharpProjectGenerator();
	    projGen.build(implDir, generatedFilenames);
	    
		String modelSupportDir = "Model.Support" + sl;
		String parsersSupportDir = "Parsers.Support" + sl;
		
		ZipGenerator zip = new ZipGenerator(destDir + "CSharp.zip");
		zip.addFiles(implDir+modelDir, modelDir, ".cs");
		zip.addFiles(implDir+parsersDir, parsersDir, ".cs");
		zip.addFiles(implDir+modelSupportDir, modelSupportDir, ".cs");
		zip.addFiles(implDir+parsersSupportDir, parsersSupportDir, ".cs");
		zip.addFiles(implDir + sl + "Properties" + sl, "Properties"+sl, ".cs");
		zip.addFiles(implDir + sl, "", ".csproj");
		zip.addFiles(implDir + sl, "", ".sln");
		zip.close();		
	}

}
