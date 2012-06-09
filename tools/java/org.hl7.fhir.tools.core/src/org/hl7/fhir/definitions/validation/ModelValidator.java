package org.hl7.fhir.definitions.validation;
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
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.TypeRef;

public class ModelValidator {

  private Definitions definitions;
	private List<String> errors = new ArrayList<String>();

	
	public ModelValidator(Definitions definitions) {
	  super();
	  this.definitions = definitions;
	}

//	public void setConceptDomains(List<ConceptDomain> conceptDomains) {
//		this.conceptDomains = conceptDomains;
//	}
//
//	public void defineResource(String name) {
//		this.resources.add(name);
//	}
//
//	public void setDataTypes(String[] names) throws Exception {
//		TypeParser tp = new TypeParser();
//		for (String tn : names) {
//			datatypes.addAll(tp.parse(tn));
//		}
//	}

	public List<String> check(String name, ElementDefn root) {
		errors.clear();
		checkElement(root.getName(), root);
		return errors;
	}

	private void checkElement(String path, ElementDefn e) {
		rule(path, e.unbounded() || e.getMaxCardinality() == 1, "Max Cardinality must be 1 or unbounded");
		rule(path, e.getMinCardinality() == 0 || e.getMinCardinality() == 1, "Min Cardinality must be 0 or 1");
//		if (e.getConformance() == ElementDefn.Conformance.Mandatory && !e.unbounded())
//		  rule(path, e.getMinCardinality() > 0, "Min Cardinality cannot be 0 when element is mandatory");
		if (!e.getName().equals("#"))
		rule(path, e.hasShortDefn() || e.getElements().size() > 0, "Must have a short defn unless child elements exist");
		checkType(path, e);
		rule(path, !"code".equals(e.typeCode()) || e.hasBinding(), "Must have a binding if type is 'code'");
		  
		if (e.hasBinding())
		{
			BindingSpecification cd = definitions.getBindingByName(e.getBindingName());
			rule(path, cd  != null, "Unable to resolve concept domain "+e.getBindingName());
//			if (cd != null)
//		      rule(path, (cd.getBinding() == ConceptDomain.Binding.CodeList && (e.hasType("Coding") || e.hasType("CodeableConcept"))), "A binding can only be extensible if an element has a type of Coding|CodeableConcept and the concept domain is bound directly to a code list.");
		}
		for (ElementDefn c : e.getElements()) {
			checkElement(path+"."+c.getName(), c);
		}
		
	}

	private void checkType(String path, ElementDefn e) {
		if (e.getTypes().size() == 0) {
			rule(path, path.contains("."), "Must have a type on a base element");
			rule(path, e.getName().equals("extensions") || e.getElements().size() > 0, "Must have a type unless sub-elements exist");
		} else {
			for (TypeRef t : e.getTypes()) {
				String s = t.getName();
				if (s.charAt(0) == '@') {
					// validate path
				} else {
					if (s.charAt(0) == '#')
						s = s.substring(1);
					if (!t.isSpecialType()) {
						rule(path, typeExists(s), "Illegal Type '"+s+"'");
						if (s.equals("Resource")) {
							for (String p : t.getParams()) {
								rule(path, p.equals("Any") || definitions.hasResource(p), "Unknown resource type "+p);
							}
						}
					}
				}
			}		
		}
		
	}


	private boolean typeExists(String name) {
		return definitions.hasType(name);
	}

	private void rule(String path, boolean b, String msg) {
		if (!b)
			errors.add(path+": "+msg);
		
	}
	
	
}
