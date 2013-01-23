package org.hl7.fhir.instance.formats;

/*
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

// Generated on Wed, Jan 23, 2013 13:24+1100 for FHIR v0.07

import org.hl7.fhir.instance.model.*;
import org.hl7.fhir.instance.model.Integer;
import org.hl7.fhir.instance.model.Boolean;
import java.net.*;
import java.math.*;

public class XmlComposer extends XmlComposerBase {

  private <E extends Enum<E>> void composeEnumeration(String name, Enumeration<E> value, EnumFactory e) throws Exception {
    if (value != null) {
      composeElementAttributes(value);
      if (value.getValue() != null) 
        xml.attribute("value", e.toCode(value.getValue()));
        
      xml.open(FHIR_NS, name);
      for (Extension ex : value.getExtensions())
        composeExtension("extension", ex);
      xml.close(FHIR_NS, name);
    }    
  }    

  private void composeInteger(String name, Integer value) throws Exception {
    if (value != null) {
      composeElementAttributes(value);
        xml.attribute("value", toString(value.getValue()));
        
      xml.open(FHIR_NS, name);
      for (Extension e : value.getExtensions())
        composeExtension("extension", e);
      xml.close(FHIR_NS, name);
    }    
  }    

  private void composeDateTime(String name, DateTime value) throws Exception {
    if (value != null) {
      composeElementAttributes(value);
      if (value.getValue() != null) 
        xml.attribute("value", toString(value.getValue()));
        
      xml.open(FHIR_NS, name);
      for (Extension e : value.getExtensions())
        composeExtension("extension", e);
      xml.close(FHIR_NS, name);
    }    
  }    

  private void composeCode(String name, Code value) throws Exception {
    if (value != null) {
      composeElementAttributes(value);
      if (value.getValue() != null) 
        xml.attribute("value", toString(value.getValue()));
        
      xml.open(FHIR_NS, name);
      for (Extension e : value.getExtensions())
        composeExtension("extension", e);
      xml.close(FHIR_NS, name);
    }    
  }    

  private void composeDate(String name, Date value) throws Exception {
    if (value != null) {
      composeElementAttributes(value);
      if (value.getValue() != null) 
        xml.attribute("value", toString(value.getValue()));
        
      xml.open(FHIR_NS, name);
      for (Extension e : value.getExtensions())
        composeExtension("extension", e);
      xml.close(FHIR_NS, name);
    }    
  }    

  private void composeDecimal(String name, Decimal value) throws Exception {
    if (value != null) {
      composeElementAttributes(value);
      if (value.getValue() != null) 
        xml.attribute("value", toString(value.getValue()));
        
      xml.open(FHIR_NS, name);
      for (Extension e : value.getExtensions())
        composeExtension("extension", e);
      xml.close(FHIR_NS, name);
    }    
  }    

  private void composeUri(String name, Uri value) throws Exception {
    if (value != null) {
      composeElementAttributes(value);
      if (value.getValue() != null) 
        xml.attribute("value", toString(value.getValue()));
        
      xml.open(FHIR_NS, name);
      for (Extension e : value.getExtensions())
        composeExtension("extension", e);
      xml.close(FHIR_NS, name);
    }    
  }    

  private void composeId(String name, Id value) throws Exception {
    if (value != null) {
      composeElementAttributes(value);
      if (value.getValue() != null) 
        xml.attribute("value", toString(value.getValue()));
        
      xml.open(FHIR_NS, name);
      for (Extension e : value.getExtensions())
        composeExtension("extension", e);
      xml.close(FHIR_NS, name);
    }    
  }    

  private void composeBase64Binary(String name, Base64Binary value) throws Exception {
    if (value != null) {
      composeElementAttributes(value);
      if (value.getValue() != null) 
        xml.attribute("value", toString(value.getValue()));
        
      xml.open(FHIR_NS, name);
      for (Extension e : value.getExtensions())
        composeExtension("extension", e);
      xml.close(FHIR_NS, name);
    }    
  }    

  private void composeOid(String name, Oid value) throws Exception {
    if (value != null) {
      composeElementAttributes(value);
      if (value.getValue() != null) 
        xml.attribute("value", toString(value.getValue()));
        
      xml.open(FHIR_NS, name);
      for (Extension e : value.getExtensions())
        composeExtension("extension", e);
      xml.close(FHIR_NS, name);
    }    
  }    

  private void composeString(String name, String_ value) throws Exception {
    if (value != null) {
      composeElementAttributes(value);
      if (value.getValue() != null) 
        xml.attribute("value", toString(value.getValue()));
        
      xml.open(FHIR_NS, name);
      for (Extension e : value.getExtensions())
        composeExtension("extension", e);
      xml.close(FHIR_NS, name);
    }    
  }    

  private void composeBoolean(String name, Boolean value) throws Exception {
    if (value != null) {
      composeElementAttributes(value);
        xml.attribute("value", toString(value.getValue()));
        
      xml.open(FHIR_NS, name);
      for (Extension e : value.getExtensions())
        composeExtension("extension", e);
      xml.close(FHIR_NS, name);
    }    
  }    

  private void composeUuid(String name, Uuid value) throws Exception {
    if (value != null) {
      composeElementAttributes(value);
      if (value.getValue() != null) 
        xml.attribute("value", toString(value.getValue()));
        
      xml.open(FHIR_NS, name);
      for (Extension e : value.getExtensions())
        composeExtension("extension", e);
      xml.close(FHIR_NS, name);
    }    
  }    

  private void composeInstant(String name, Instant value) throws Exception {
    if (value != null) {
      composeElementAttributes(value);
      if (value.getValue() != null) 
        xml.attribute("value", toString(value.getValue()));
        
      xml.open(FHIR_NS, name);
      for (Extension e : value.getExtensions())
        composeExtension("extension", e);
      xml.close(FHIR_NS, name);
    }    
  }    

  private void composeExtension(String name, Extension element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeUri("url", element.getUrl());
      composeString("ref", element.getRef());
      composeBoolean("mustUnderstand", element.getMustUnderstand());
      composeType("value", element.getValue());
      for (Extension e : element.getExtension()) 
        composeExtension("extension", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeNarrative(String name, Narrative element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new Narrative().new NarrativeStatusEnumFactory());
      composeXhtml("div", element.getDiv());
      for (Narrative.Image e : element.getImage()) 
        composeNarrativeImage("image", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeNarrativeImage(String name, Narrative.Image element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCode("mimeType", element.getMimeType());
      composeBase64Binary("content", element.getContent());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePeriod(String name, Period element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeDateTime("start", element.getStart());
      composeDateTime("end", element.getEnd());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeCoding(String name, Coding element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeUri("system", element.getSystem());
      composeCode("code", element.getCode());
      composeString("display", element.getDisplay());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeRange(String name, Range element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeQuantity("low", element.getLow());
      composeQuantity("high", element.getHigh());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeQuantity(String name, Quantity element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeDecimal("value", element.getValue());
      if (element.getComparator() != null)
        composeEnumeration("comparator", element.getComparator(), new Quantity().new QuantityComparatorEnumFactory());
      composeString("units", element.getUnits());
      composeUri("system", element.getSystem());
      composeCode("code", element.getCode());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeChoice(String name, Choice element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeCode("code", element.getCode());
      for (Choice.Option e : element.getOption()) 
        composeChoiceOption("option", e);
      composeBoolean("isOrdered", element.getIsOrdered());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeChoiceOption(String name, Choice.Option element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCode("code", element.getCode());
      composeString("display", element.getDisplay());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeAttachment(String name, Attachment element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      if (element.getLanguage() != null)
        xml.attribute("xml:lang", element.getLanguage().toString());
      xml.open(FHIR_NS, name);
      composeCode("contentType", element.getContentType());
      composeBase64Binary("data", element.getData());
      composeUri("url", element.getUrl());
      composeInteger("size", element.getSize());
      composeBase64Binary("hash", element.getHash());
      composeString("title", element.getTitle());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeRatio(String name, Ratio element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeQuantity("numerator", element.getNumerator());
      composeQuantity("denominator", element.getDenominator());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeResourceReference(String name, ResourceReference element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeCode("type", element.getType());
      composeUri("url", element.getUrl());
      composeString("display", element.getDisplay());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeCodeableConcept(String name, CodeableConcept element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      for (Coding e : element.getCoding()) 
        composeCoding("coding", e);
      composeString("text", element.getText());
      composeString("primary", element.getPrimary());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeIdentifier(String name, Identifier element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getUse() != null)
        composeEnumeration("use", element.getUse(), new Identifier().new IdentifierUseEnumFactory());
      composeString("label", element.getLabel());
      composeUri("system", element.getSystem());
      composeString("id", element.getId());
      composePeriod("period", element.getPeriod());
      composeResourceReference("assigner", element.getAssigner());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeAge(String name, Age element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeDecimal("value", element.getValue());
      if (element.getComparator() != null)
        composeEnumeration("comparator", element.getComparator(), new Age().new QuantityComparatorEnumFactory());
      composeString("units", element.getUnits());
      composeUri("system", element.getSystem());
      composeCode("code", element.getCode());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeCount(String name, Count element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeDecimal("value", element.getValue());
      if (element.getComparator() != null)
        composeEnumeration("comparator", element.getComparator(), new Count().new QuantityComparatorEnumFactory());
      composeString("units", element.getUnits());
      composeUri("system", element.getSystem());
      composeCode("code", element.getCode());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMoney(String name, Money element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeDecimal("value", element.getValue());
      if (element.getComparator() != null)
        composeEnumeration("comparator", element.getComparator(), new Money().new QuantityComparatorEnumFactory());
      composeString("units", element.getUnits());
      composeUri("system", element.getSystem());
      composeCode("code", element.getCode());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDistance(String name, Distance element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeDecimal("value", element.getValue());
      if (element.getComparator() != null)
        composeEnumeration("comparator", element.getComparator(), new Distance().new QuantityComparatorEnumFactory());
      composeString("units", element.getUnits());
      composeUri("system", element.getSystem());
      composeCode("code", element.getCode());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDuration(String name, Duration element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeDecimal("value", element.getValue());
      if (element.getComparator() != null)
        composeEnumeration("comparator", element.getComparator(), new Duration().new QuantityComparatorEnumFactory());
      composeString("units", element.getUnits());
      composeUri("system", element.getSystem());
      composeCode("code", element.getCode());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeSchedule(String name, Schedule element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      for (Period e : element.getEvent()) 
        composePeriod("event", e);
      composeScheduleRepeat("repeat", element.getRepeat());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeScheduleRepeat(String name, Schedule.Repeat element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeInteger("frequency", element.getFrequency());
      if (element.getWhen() != null)
        composeEnumeration("when", element.getWhen(), new Schedule().new EventTimingEnumFactory());
      composeDecimal("duration", element.getDuration());
      if (element.getUnits() != null)
        composeEnumeration("units", element.getUnits(), new Schedule().new UnitsOfTimeEnumFactory());
      composeInteger("count", element.getCount());
      composeDateTime("end", element.getEnd());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeContact(String name, Contact element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getSystem() != null)
        composeEnumeration("system", element.getSystem(), new Contact().new ContactSystemEnumFactory());
      composeString("value", element.getValue());
      if (element.getUse() != null)
        composeEnumeration("use", element.getUse(), new Contact().new ContactUseEnumFactory());
      composePeriod("period", element.getPeriod());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeAddress(String name, Address element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getUse() != null)
        composeEnumeration("use", element.getUse(), new Address().new AddressUseEnumFactory());
      composeString("text", element.getText());
      for (String_ e : element.getLine()) 
        composeString("line", e);
      composeString("city", element.getCity());
      composeString("state", element.getState());
      composeString("zip", element.getZip());
      composeString("country", element.getCountry());
      composePeriod("period", element.getPeriod());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeHumanName(String name, HumanName element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getUse() != null)
        composeEnumeration("use", element.getUse(), new HumanName().new NameUseEnumFactory());
      composeString("text", element.getText());
      for (String_ e : element.getFamily()) 
        composeString("family", e);
      for (String_ e : element.getGiven()) 
        composeString("given", e);
      for (String_ e : element.getPrefix()) 
        composeString("prefix", e);
      for (String_ e : element.getSuffix()) 
        composeString("suffix", e);
      composePeriod("period", element.getPeriod());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDocumentInformation(String name, DocumentInformation element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeIdentifier("id", element.getId());
      composeIdentifier("versionId", element.getVersionId());
      composeInstant("created", element.getCreated());
      composeCoding("class", element.getClass_());
      composeCodeableConcept("type", element.getType());
      composeString("title", element.getTitle());
      composeCoding("confidentiality", element.getConfidentiality());
      composeResourceReference("subject", element.getSubject());
      for (ResourceReference e : element.getAuthor()) 
        composeResourceReference("author", e);
      for (DocumentInformation.Attester e : element.getAttester()) 
        composeDocumentInformationAttester("attester", e);
      composeResourceReference("custodian", element.getCustodian());
      composeDocumentInformationEvent("event", element.getEvent());
      composeResourceReference("encounter", element.getEncounter());
      composeCodeableConcept("facilityType", element.getFacilityType());
      composeCodeableConcept("practiceSetting", element.getPracticeSetting());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDocumentInformationAttester(String name, DocumentInformation.Attester element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getMode() != null)
        composeEnumeration("mode", element.getMode(), new DocumentInformation().new DocumentAttestationModeEnumFactory());
      composeDateTime("time", element.getTime());
      composeResourceReference("party", element.getParty());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDocumentInformationEvent(String name, DocumentInformation.Event element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      for (CodeableConcept e : element.getCode()) 
        composeCodeableConcept("code", e);
      composePeriod("period", element.getPeriod());
      for (ResourceReference e : element.getDetail()) 
        composeResourceReference("detail", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDemographics(String name, Demographics element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      for (HumanName e : element.getName()) 
        composeHumanName("name", e);
      for (Contact e : element.getTelecom()) 
        composeContact("telecom", e);
      composeCoding("gender", element.getGender());
      composeDateTime("birthDate", element.getBirthDate());
      composeBoolean("deceased", element.getDeceased());
      for (Address e : element.getAddress()) 
        composeAddress("address", e);
      composeCodeableConcept("maritalStatus", element.getMaritalStatus());
      for (Demographics.Language e : element.getLanguage()) 
        composeDemographicsLanguage("language", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDemographicsLanguage(String name, Demographics.Language element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("language", element.getLanguage());
      composeCodeableConcept("mode", element.getMode());
      composeCodeableConcept("proficiencyLevel", element.getProficiencyLevel());
      composeBoolean("preference", element.getPreference());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeResourceAttributes(Resource element) {
  }
  private void composeResourceElements(Resource element) throws Exception {
    composeNarrative("text", element.getText());
    for (Extension e : element.getExtensions()) {
      composeExtension("extension", e);
    }
  }

  private void composeCarePlan(String name, CarePlan element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeResourceReference("patient", element.getPatient());
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new CarePlan().new CarePlanStatusEnumFactory());
      composePeriod("period", element.getPeriod());
      composeDateTime("modified", element.getModified());
      for (ResourceReference e : element.getCondition()) 
        composeResourceReference("condition", e);
      for (CarePlan.Participant e : element.getParticipant()) 
        composeCarePlanParticipant("participant", e);
      composeString("goal", element.getGoal());
      for (CarePlan.Activity e : element.getActivity()) 
        composeCarePlanActivity("activity", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeCarePlanParticipant(String name, CarePlan.Participant element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("role", element.getRole());
      composeResourceReference("member", element.getMember());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeCarePlanActivity(String name, CarePlan.Activity element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getCategory() != null)
        composeEnumeration("category", element.getCategory(), new CarePlan().new CarePlanActivityCategoryEnumFactory());
      composeCodeableConcept("code", element.getCode());
      composeSchedule("schedule", element.getSchedule());
      composeResourceReference("location", element.getLocation());
      for (ResourceReference e : element.getPerformer()) 
        composeResourceReference("performer", e);
      composeResourceReference("product", element.getProduct());
      composeQuantity("dailyAmount", element.getDailyAmount());
      composeQuantity("quantity", element.getQuantity());
      composeString("details", element.getDetails());
      for (ResourceReference e : element.getAction()) 
        composeResourceReference("action", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProvenance(String name, Provenance element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeResourceReference("target", element.getTarget());
      composeProvenanceActivity("activity", element.getActivity());
      for (Provenance.Party e : element.getParty()) 
        composeProvenanceParty("party", e);
      composeString("signature", element.getSignature());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProvenanceActivity(String name, Provenance.Activity element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composePeriod("period", element.getPeriod());
      composeInstant("recorded", element.getRecorded());
      composeCodeableConcept("reason", element.getReason());
      composeProvenanceLocation("location", element.getLocation());
      composeUri("policy", element.getPolicy());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProvenanceLocation(String name, Provenance.Location element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("type", element.getType());
      composeIdentifier("id", element.getId());
      composeString("description", element.getDescription());
      composeString("coords", element.getCoords());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProvenanceParty(String name, Provenance.Party element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCoding("role", element.getRole());
      composeCoding("type", element.getType());
      composeUri("id", element.getId());
      composeString("description", element.getDescription());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDevice(String name, Device element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeCodeableConcept("type", element.getType());
      composeString("manufacturer", element.getManufacturer());
      composeString("model", element.getModel());
      composeString("version", element.getVersion());
      composeDeviceIdentity("identity", element.getIdentity());
      composeResourceReference("owner", element.getOwner());
      for (Identifier e : element.getAssignedId()) 
        composeIdentifier("assignedId", e);
      composeResourceReference("location", element.getLocation());
      composeResourceReference("patient", element.getPatient());
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      composeUri("url", element.getUrl());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDeviceIdentity(String name, Device.Identity element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("gtin", element.getGtin());
      composeString("lot", element.getLot());
      composeString("serialNumber", element.getSerialNumber());
      composeDate("expiry", element.getExpiry());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeOrder(String name, Order element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeDateTime("date", element.getDate());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("source", element.getSource());
      composeResourceReference("target", element.getTarget());
      composeString("reason", element.getReason());
      composeResourceReference("authority", element.getAuthority());
      composeResourceReference("payment", element.getPayment());
      composeOrderWhen("when", element.getWhen());
      for (ResourceReference e : element.getDetail()) 
        composeResourceReference("detail", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeOrderWhen(String name, Order.When element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("code", element.getCode());
      composeSchedule("schedule", element.getSchedule());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeOrganization(String name, Organization element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      for (Identifier e : element.getIdentifier()) 
        composeIdentifier("identifier", e);
      for (String_ e : element.getName()) 
        composeString("name", e);
      for (Address e : element.getAddress()) 
        composeAddress("address", e);
      for (Contact e : element.getTelecom()) 
        composeContact("telecom", e);
      composeCodeableConcept("type", element.getType());
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new Organization().new RecordStatusEnumFactory());
      for (Organization.Accreditation e : element.getAccreditation()) 
        composeOrganizationAccreditation("accreditation", e);
      for (Organization.RelatedOrganization e : element.getRelatedOrganization()) 
        composeOrganizationRelatedOrganization("relatedOrganization", e);
      for (Organization.ContactPerson e : element.getContactPerson()) 
        composeOrganizationContactPerson("contactPerson", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeOrganizationAccreditation(String name, Organization.Accreditation element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeIdentifier("identifier", element.getIdentifier());
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("institution", element.getInstitution());
      composePeriod("period", element.getPeriod());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeOrganizationRelatedOrganization(String name, Organization.RelatedOrganization element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceReference("organization", element.getOrganization());
      composeCodeableConcept("type", element.getType());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeOrganizationContactPerson(String name, Organization.ContactPerson element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("type", element.getType());
      composeAddress("address", element.getAddress());
      for (Contact e : element.getTelecom()) 
        composeContact("telecom", e);
      composeHumanName("name", element.getName());
      composeResourceReference("person", element.getPerson());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescription(String name, Prescription element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      for (Identifier e : element.getIdentifier()) 
        composeIdentifier("identifier", e);
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new Prescription().new PrescriptionStatusEnumFactory());
      composeResourceReference("patient", element.getPatient());
      composeResourceReference("prescriber", element.getPrescriber());
      composeDateTime("prescribed", element.getPrescribed());
      composePrescriptionDispense("dispense", element.getDispense());
      composePrescriptionMedicine("medicine", element.getMedicine());
      composePrescriptionAdministrationRequest("administrationRequest", element.getAdministrationRequest());
      composeCodeableConcept("reason", element.getReason());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescriptionDispense(String name, Prescription.Dispense element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeInteger("repeats", element.getRepeats());
      composeQuantity("quantity", element.getQuantity());
      composeResourceReference("dispenser", element.getDispenser());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescriptionMedicine(String name, Prescription.Medicine element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("identification", element.getIdentification());
      for (Prescription.ActiveIngredient e : element.getActiveIngredient()) 
        composePrescriptionActiveIngredient("activeIngredient", e);
      for (Prescription.InactiveIngredient e : element.getInactiveIngredient()) 
        composePrescriptionInactiveIngredient("inactiveIngredient", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescriptionActiveIngredient(String name, Prescription.ActiveIngredient element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("identification", element.getIdentification());
      composeType("quantity", element.getQuantity());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescriptionInactiveIngredient(String name, Prescription.InactiveIngredient element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("identification", element.getIdentification());
      composeType("quantity", element.getQuantity());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescriptionAdministrationRequest(String name, Prescription.AdministrationRequest element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("description", element.getDescription());
      composeRatio("totalPeriodicDose", element.getTotalPeriodicDose());
      composeDateTime("start", element.getStart());
      composeDateTime("end", element.getEnd());
      composeQuantity("duration", element.getDuration());
      composeInteger("numberOfAdministrations", element.getNumberOfAdministrations());
      for (Prescription.DosageInstruction e : element.getDosageInstruction()) 
        composePrescriptionDosageInstruction("dosageInstruction", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescriptionDosageInstruction(String name, Prescription.DosageInstruction element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      for (CodeableConcept e : element.getPrecondition()) 
        composeCodeableConcept("precondition", e);
      composeBoolean("prn", element.getPrn());
      for (CodeableConcept e : element.getAdditionalInstruction()) 
        composeCodeableConcept("additionalInstruction", e);
      composeCodeableConcept("route", element.getRoute());
      composeType("dose", element.getDose());
      composeQuantity("rate", element.getRate());
      for (Schedule e : element.getSchedule()) 
        composeSchedule("schedule", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeGroup(String name, Group element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeIdentifier("identifier", element.getIdentifier());
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new Group().new GroupTypeEnumFactory());
      composeBoolean("actual", element.getActual());
      composeCodeableConcept("code", element.getCode());
      composeString("name", element.getName());
      composeInteger("quantity", element.getQuantity());
      for (Group.Characteristic e : element.getCharacteristic()) 
        composeGroupCharacteristic("characteristic", e);
      for (ResourceReference e : element.getMember()) 
        composeResourceReference("member", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeGroupCharacteristic(String name, Group.Characteristic element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("type", element.getType());
      composeType("value", element.getValue());
      composeBoolean("exclude", element.getExclude());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeValueSet(String name, ValueSet element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeString("name", element.getName());
      composeValueSetAuthor("author", element.getAuthor());
      composeString("description", element.getDescription());
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new ValueSet().new ValuesetStatusEnumFactory());
      composeDateTime("date", element.getDate());
      composeString("identifier", element.getIdentifier());
      composeString("version", element.getVersion());
      for (Uri e : element.getRestricts()) 
        composeUri("restricts", e);
      for (Uri e : element.getImport()) 
        composeUri("import", e);
      for (ValueSet.Include e : element.getInclude()) 
        composeValueSetInclude("include", e);
      for (ValueSet.Include e : element.getExclude()) 
        composeValueSetInclude("exclude", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeValueSetAuthor(String name, ValueSet.Author element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      composeUri("reference", element.getReference());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeValueSetInclude(String name, ValueSet.Include element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeUri("system", element.getSystem());
      composeString("version", element.getVersion());
      if (element.getMode() != null)
        composeEnumeration("mode", element.getMode(), new ValueSet().new CodeSelectionModeEnumFactory());
      for (Code e : element.getCode()) 
        composeCode("code", e);
      for (ValueSet.Filter e : element.getFilter()) 
        composeValueSetFilter("filter", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeValueSetFilter(String name, ValueSet.Filter element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCode("property", element.getProperty());
      if (element.getOp() != null)
        composeEnumeration("op", element.getOp(), new ValueSet().new FilterOperatorEnumFactory());
      composeCode("value", element.getValue());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeCoverage(String name, Coverage element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeResourceReference("issuer", element.getIssuer());
      composePeriod("period", element.getPeriod());
      composeCoding("type", element.getType());
      composeIdentifier("identifier", element.getIdentifier());
      composeIdentifier("plan", element.getPlan());
      composeIdentifier("subplan", element.getSubplan());
      composeInteger("dependent", element.getDependent());
      composeInteger("sequence", element.getSequence());
      composeCoveragePlanHolder("planHolder", element.getPlanHolder());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeCoveragePlanHolder(String name, Coverage.PlanHolder element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeHumanName("name", element.getName());
      composeAddress("address", element.getAddress());
      composeDate("birthdate", element.getBirthdate());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeTest(String name, Test element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      for (String_ e : element.getStringErr()) 
        composeString("stringErr", e);
      for (String_ e : element.getStringCorr()) 
        composeString("stringCorr", e);
      for (Boolean e : element.getBooleanErr()) 
        composeBoolean("booleanErr", e);
      for (Boolean e : element.getBooleanCorr()) 
        composeBoolean("booleanCorr", e);
      for (Integer e : element.getIntegerErr()) 
        composeInteger("integerErr", e);
      for (Integer e : element.getIntegerCorr()) 
        composeInteger("integerCorr", e);
      for (Decimal e : element.getDecimalErr()) 
        composeDecimal("decimalErr", e);
      for (Decimal e : element.getDecimalCorr()) 
        composeDecimal("decimalCorr", e);
      for (Base64Binary e : element.getB64Err()) 
        composeBase64Binary("b64Err", e);
      for (Base64Binary e : element.getB64Corr()) 
        composeBase64Binary("b64Corr", e);
      for (Instant e : element.getInstantErr()) 
        composeInstant("instantErr", e);
      for (Instant e : element.getInstantCorr()) 
        composeInstant("instantCorr", e);
      for (Uri e : element.getUriErr()) 
        composeUri("uriErr", e);
      for (Uri e : element.getUriCorr()) 
        composeUri("uriCorr", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMedicationAdministration(String name, MedicationAdministration element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      if (element.getAdministrationEventStatus() != null)
        composeEnumeration("administrationEventStatus", element.getAdministrationEventStatus(), new MedicationAdministration().new MedAdmStatusEnumFactory());
      composeBoolean("isNegated", element.getIsNegated());
      for (CodeableConcept e : element.getNegatedReason()) 
        composeCodeableConcept("negatedReason", e);
      composePeriod("effectiveTime", element.getEffectiveTime());
      composeCodeableConcept("method", element.getMethod());
      composeCodeableConcept("approachSite", element.getApproachSite());
      composeCodeableConcept("route", element.getRoute());
      composeQuantity("administeredDose", element.getAdministeredDose());
      composeQuantity("doseRate", element.getDoseRate());
      for (Identifier e : element.getId()) 
        composeIdentifier("id", e);
      composeResourceReference("prescription", element.getPrescription());
      composeResourceReference("patient", element.getPatient());
      for (CodeableConcept e : element.getMedication()) 
        composeCodeableConcept("medication", e);
      composeIdentifier("encounter", element.getEncounter());
      for (ResourceReference e : element.getAdministrationDevice()) 
        composeResourceReference("administrationDevice", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeSecurityEvent(String name, SecurityEvent element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeSecurityEventEvent("event", element.getEvent());
      for (SecurityEvent.Participant e : element.getParticipant()) 
        composeSecurityEventParticipant("participant", e);
      for (SecurityEvent.Source e : element.getSource()) 
        composeSecurityEventSource("source", e);
      for (SecurityEvent.Object e : element.getObject()) 
        composeSecurityEventObject("object", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeSecurityEventEvent(String name, SecurityEvent.Event element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCoding("id", element.getId());
      if (element.getAction() != null)
        composeEnumeration("action", element.getAction(), new SecurityEvent().new SecurityEventEventActionEnumFactory());
      composeInstant("dateTime", element.getDateTime());
      if (element.getOutcome() != null)
        composeEnumeration("outcome", element.getOutcome(), new SecurityEvent().new SecurityEventEventOutcomeEnumFactory());
      for (Coding e : element.getCode()) 
        composeCoding("code", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeSecurityEventParticipant(String name, SecurityEvent.Participant element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("userId", element.getUserId());
      composeString("otherUserId", element.getOtherUserId());
      composeString("name", element.getName());
      composeBoolean("requestor", element.getRequestor());
      for (Coding e : element.getRole()) 
        composeCoding("role", e);
      composeSecurityEventNetwork("network", element.getNetwork());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeSecurityEventNetwork(String name, SecurityEvent.Network element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new SecurityEvent().new NetworkTypeEnumFactory());
      composeString("id", element.getId());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeSecurityEventSource(String name, SecurityEvent.Source element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("site", element.getSite());
      composeString("id", element.getId());
      for (Coding e : element.getType()) 
        composeCoding("type", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeSecurityEventObject(String name, SecurityEvent.Object element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new SecurityEvent().new ObjectTypeEnumFactory());
      if (element.getRole() != null)
        composeEnumeration("role", element.getRole(), new SecurityEvent().new ObjectRoleEnumFactory());
      if (element.getLifecycle() != null)
        composeEnumeration("lifecycle", element.getLifecycle(), new SecurityEvent().new ObjectLifecycleEnumFactory());
      composeCoding("idType", element.getIdType());
      composeString("id", element.getId());
      composeString("sensitivity", element.getSensitivity());
      composeString("name", element.getName());
      composeBase64Binary("query", element.getQuery());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeIssueReport(String name, IssueReport element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      for (IssueReport.Issue e : element.getIssue()) 
        composeIssueReportIssue("issue", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeIssueReportIssue(String name, IssueReport.Issue element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getSeverity() != null)
        composeEnumeration("severity", element.getSeverity(), new IssueReport().new IssueSeverityEnumFactory());
      composeCodeableConcept("type", element.getType());
      composeString("details", element.getDetails());
      for (String_ e : element.getLocation()) 
        composeString("location", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeList_(String name, List_ element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("source", element.getSource());
      composeDateTime("date", element.getDate());
      composeBoolean("ordered", element.getOrdered());
      if (element.getMode() != null)
        composeEnumeration("mode", element.getMode(), new List_().new ListModeEnumFactory());
      for (List_.Entry e : element.getEntry()) 
        composeList_Entry("entry", e);
      composeCodeableConcept("emptyReason", element.getEmptyReason());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeList_Entry(String name, List_.Entry element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      for (CodeableConcept e : element.getFlag()) 
        composeCodeableConcept("flag", e);
      composeBoolean("deleted", element.getDeleted());
      composeResourceReference("item", element.getItem());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeLabReport(String name, LabReport element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new LabReport().new LabReportStatusEnumFactory());
      composeInstant("issued", element.getIssued());
      composeResourceReference("patient", element.getPatient());
      composeResourceReference("admission", element.getAdmission());
      composeResourceReference("laboratory", element.getLaboratory());
      composeIdentifier("reportId", element.getReportId());
      for (LabReport.RequestDetail e : element.getRequestDetail()) 
        composeLabReportRequestDetail("requestDetail", e);
      composeCodeableConcept("reportName", element.getReportName());
      composeCodeableConcept("service", element.getService());
      composeDateTime("diagnosticTime", element.getDiagnosticTime());
      for (ResourceReference e : element.getSpecimen()) 
        composeResourceReference("specimen", e);
      for (LabReport.ResultGroup e : element.getResultGroup()) 
        composeLabReportResultGroup("resultGroup", e);
      composeString("conclusion", element.getConclusion());
      for (CodeableConcept e : element.getCodedDiagnosis()) 
        composeCodeableConcept("codedDiagnosis", e);
      for (Attachment e : element.getRepresentation()) 
        composeAttachment("representation", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeLabReportRequestDetail(String name, LabReport.RequestDetail element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeIdentifier("requestOrderId", element.getRequestOrderId());
      composeIdentifier("receiverOrderId", element.getReceiverOrderId());
      for (CodeableConcept e : element.getRequestTest()) 
        composeCodeableConcept("requestTest", e);
      composeResourceReference("requester", element.getRequester());
      composeResourceReference("clinicalInfo", element.getClinicalInfo());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeLabReportResultGroup(String name, LabReport.ResultGroup element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("name", element.getName());
      composeResourceReference("specimen", element.getSpecimen());
      for (LabReport.Result e : element.getResult()) 
        composeLabReportResult("result", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeLabReportResult(String name, LabReport.Result element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("name", element.getName());
      composeType("value", element.getValue());
      if (element.getFlag() != null)
        composeEnumeration("flag", element.getFlag(), new LabReport().new LabResultFlagEnumFactory());
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new LabReport().new LabReportStatusEnumFactory());
      composeString("comments", element.getComments());
      for (LabReport.ReferenceRange e : element.getReferenceRange()) 
        composeLabReportReferenceRange("referenceRange", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeLabReportReferenceRange(String name, LabReport.ReferenceRange element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("meaning", element.getMeaning());
      composeType("range", element.getRange());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformance(String name, Conformance element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeDateTime("date", element.getDate());
      composeConformancePublisher("publisher", element.getPublisher());
      composeConformanceImplementation("implementation", element.getImplementation());
      composeConformanceSoftware("software", element.getSoftware());
      composeConformanceProposal("proposal", element.getProposal());
      composeId("version", element.getVersion());
      composeBoolean("acceptUnknown", element.getAcceptUnknown());
      for (Conformance.Rest e : element.getRest()) 
        composeConformanceRest("rest", e);
      for (Conformance.Messaging e : element.getMessaging()) 
        composeConformanceMessaging("messaging", e);
      for (Conformance.Document e : element.getDocument()) 
        composeConformanceDocument("document", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformancePublisher(String name, Conformance.Publisher element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      composeAddress("address", element.getAddress());
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceImplementation(String name, Conformance.Implementation element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("description", element.getDescription());
      composeUri("url", element.getUrl());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceSoftware(String name, Conformance.Software element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      composeString("version", element.getVersion());
      composeDateTime("releaseDate", element.getReleaseDate());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceProposal(String name, Conformance.Proposal element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("description", element.getDescription());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceRest(String name, Conformance.Rest element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getMode() != null)
        composeEnumeration("mode", element.getMode(), new Conformance().new RestfulConformanceModeEnumFactory());
      composeString("documentation", element.getDocumentation());
      for (Conformance.Resource e : element.getResource()) 
        composeConformanceResource("resource", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceResource(String name, Conformance.Resource element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCode("type", element.getType());
      composeUri("profile", element.getProfile());
      for (Conformance.Operation e : element.getOperation()) 
        composeConformanceOperation("operation", e);
      composeBoolean("history", element.getHistory());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceOperation(String name, Conformance.Operation element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getCode() != null)
        composeEnumeration("code", element.getCode(), new Conformance().new RestfulOperationEnumFactory());
      composeString("documentation", element.getDocumentation());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceMessaging(String name, Conformance.Messaging element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeUri("endpoint", element.getEndpoint());
      composeString("documentation", element.getDocumentation());
      for (Conformance.Event e : element.getEvent()) 
        composeConformanceEvent("event", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceEvent(String name, Conformance.Event element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCode("code", element.getCode());
      if (element.getMode() != null)
        composeEnumeration("mode", element.getMode(), new Conformance().new MessageConformanceEventModeEnumFactory());
      for (Coding e : element.getProtocol()) 
        composeCoding("protocol", e);
      composeCode("focus", element.getFocus());
      composeUri("request", element.getRequest());
      composeUri("response", element.getResponse());
      composeString("documentation", element.getDocumentation());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceDocument(String name, Conformance.Document element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getMode() != null)
        composeEnumeration("mode", element.getMode(), new Conformance().new DocumentModeEnumFactory());
      composeString("documentation", element.getDocumentation());
      composeUri("profile", element.getProfile());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeXdsEntry(String name, XdsEntry element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeUri("url", element.getUrl());
      composeUri("repositoryId", element.getRepositoryId());
      composeString("mimeType", element.getMimeType());
      composeCoding("format", element.getFormat());
      composeCoding("class", element.getClass_());
      composeCoding("type", element.getType());
      composeString("title", element.getTitle());
      composeUri("documentId", element.getDocumentId());
      if (element.getAvailability() != null)
        composeEnumeration("availability", element.getAvailability(), new XdsEntry().new XdsEntryAvailabilityEnumFactory());
      composeCoding("confidentialityCode", element.getConfidentialityCode());
      composeInstant("created", element.getCreated());
      for (Coding e : element.getEvent()) 
        composeCoding("event", e);
      composeString("hash", element.getHash());
      composeString("size", element.getSize());
      composeString("language", element.getLanguage());
      for (ResourceReference e : element.getFolder()) 
        composeResourceReference("folder", e);
      composeIdentifier("patientId", element.getPatientId());
      composeIdentifier("sourcePatientId", element.getSourcePatientId());
      composeResourceReference("patientInfo", element.getPatientInfo());
      for (XdsEntry.Author e : element.getAuthor()) 
        composeXdsEntryAuthor("author", e);
      composeXdsEntryAuthenticator("authenticator", element.getAuthenticator());
      composeCoding("facilityType", element.getFacilityType());
      composeCoding("practiceSetting", element.getPracticeSetting());
      composeUri("homeCommunity", element.getHomeCommunity());
      composeXdsEntryService("service", element.getService());
      composeString("comments", element.getComments());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeXdsEntryAuthor(String name, XdsEntry.Author element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeHumanName("name", element.getName());
      composeIdentifier("id", element.getId());
      for (String_ e : element.getRole()) 
        composeString("role", e);
      for (String_ e : element.getSpecialty()) 
        composeString("specialty", e);
      for (XdsEntry.Institution e : element.getInstitution()) 
        composeXdsEntryInstitution("institution", e);
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeXdsEntryInstitution(String name, XdsEntry.Institution element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeIdentifier("id", element.getId());
      composeString("name", element.getName());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeXdsEntryAuthenticator(String name, XdsEntry.Authenticator element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeIdentifier("id", element.getId());
      composeHumanName("name", element.getName());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeXdsEntryService(String name, XdsEntry.Service element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeDateTime("start", element.getStart());
      composeDateTime("stop", element.getStop());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDocument(String name, Document element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeDocumentInformation("information", element.getInformation());
      composeId("replaces", element.getReplaces());
      for (ResourceReference e : element.getProvenance()) 
        composeResourceReference("provenance", e);
      composeAttachment("stylesheet", element.getStylesheet());
      composeAttachment("representation", element.getRepresentation());
      for (Document.Section e : element.getSection()) 
        composeDocumentSection("section", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDocumentSection(String name, Document.Section element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("content", element.getContent());
      for (Document.Section e : element.getSection()) 
        composeDocumentSection("section", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMessage(String name, Message element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeId("id", element.getId());
      composeInstant("instant", element.getInstant());
      composeCode("event", element.getEvent());
      composeMessageResponse("response", element.getResponse());
      composeMessageSource("source", element.getSource());
      composeMessageDestination("destination", element.getDestination());
      composeResourceReference("enterer", element.getEnterer());
      composeResourceReference("author", element.getAuthor());
      composeResourceReference("receiver", element.getReceiver());
      composeResourceReference("responsible", element.getResponsible());
      composePeriod("effective", element.getEffective());
      composeCodeableConcept("reason", element.getReason());
      for (ResourceReference e : element.getData()) 
        composeResourceReference("data", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMessageResponse(String name, Message.Response element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
      if (element.getCode() != null)
        composeEnumeration("code", element.getCode(), new Message().new ResponseCodeEnumFactory());
      composeResourceReference("details", element.getDetails());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMessageSource(String name, Message.Source element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      composeString("software", element.getSoftware());
      composeString("version", element.getVersion());
      composeContact("contact", element.getContact());
      composeUri("endpoint", element.getEndpoint());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMessageDestination(String name, Message.Destination element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      composeResourceReference("target", element.getTarget());
      composeUri("endpoint", element.getEndpoint());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfile(String name, Profile element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeString("name", element.getName());
      composeString("version", element.getVersion());
      composeProfileAuthor("author", element.getAuthor());
      composeString("description", element.getDescription());
      for (Coding e : element.getCode()) 
        composeCoding("code", e);
      composeProfileStatus("status", element.getStatus());
      for (Profile.Import e : element.getImport()) 
        composeProfileImport("import", e);
      composeCode("bundle", element.getBundle());
      for (Profile.Resource e : element.getResource()) 
        composeProfileResource("resource", e);
      for (Profile.ExtensionDefn e : element.getExtensionDefn()) 
        composeProfileExtensionDefn("extensionDefn", e);
      for (Profile.Binding e : element.getBinding()) 
        composeProfileBinding("binding", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileAuthor(String name, Profile.Author element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      for (Contact e : element.getTelecom()) 
        composeContact("telecom", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileStatus(String name, Profile.Status element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getCode() != null)
        composeEnumeration("code", element.getCode(), new Profile().new ResourceProfileStatusEnumFactory());
      composeDateTime("date", element.getDate());
      composeString("comment", element.getComment());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileImport(String name, Profile.Import element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeUri("uri", element.getUri());
      composeString("prefix", element.getPrefix());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileResource(String name, Profile.Resource element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCode("type", element.getType());
      composeUri("profile", element.getProfile());
      composeString("name", element.getName());
      composeString("purpose", element.getPurpose());
      for (Profile.Element_ e : element.getElement()) 
        composeProfileElement_("element", e);
      for (Profile.SearchParam e : element.getSearchParam()) 
        composeProfileSearchParam("searchParam", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileElement_(String name, Profile.Element_ element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("path", element.getPath());
      composeString("name", element.getName());
      composeProfileDefinition("definition", element.getDefinition());
      composeBoolean("bundled", element.getBundled());
      composeBoolean("closed", element.getClosed());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileDefinition(String name, Profile.Definition element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("short", element.getShort());
      composeString("formal", element.getFormal());
      composeString("comments", element.getComments());
      composeString("requirements", element.getRequirements());
      for (String_ e : element.getSynonym()) 
        composeString("synonym", e);
      composeInteger("min", element.getMin());
      composeString("max", element.getMax());
      for (Profile.Type e : element.getType()) 
        composeProfileType("type", e);
      composeString("nameReference", element.getNameReference());
      composeType("value", element.getValue());
      composeInteger("maxLength", element.getMaxLength());
      for (Id e : element.getCondition()) 
        composeId("condition", e);
      for (Profile.Constraint e : element.getConstraint()) 
        composeProfileConstraint("constraint", e);
      composeBoolean("mustSupport", element.getMustSupport());
      composeBoolean("mustUnderstand", element.getMustUnderstand());
      composeString("binding", element.getBinding());
      for (Profile.Mapping e : element.getMapping()) 
        composeProfileMapping("mapping", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileType(String name, Profile.Type element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCode("code", element.getCode());
      composeUri("profile", element.getProfile());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileConstraint(String name, Profile.Constraint element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
      composeString("name", element.getName());
      if (element.getSeverity() != null)
        composeEnumeration("severity", element.getSeverity(), new Profile().new ConstraintSeverityEnumFactory());
      composeString("human", element.getHuman());
      composeString("xpath", element.getXpath());
      composeString("ocl", element.getOcl());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileMapping(String name, Profile.Mapping element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("target", element.getTarget());
      composeString("map", element.getMap());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileSearchParam(String name, Profile.SearchParam element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new Profile().new SearchParamTypeEnumFactory());
      if (element.getRepeats() != null)
        composeEnumeration("repeats", element.getRepeats(), new Profile().new SearchRepeatBehaviorEnumFactory());
      composeString("documentation", element.getDocumentation());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileExtensionDefn(String name, Profile.ExtensionDefn element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
      if (element.getContextType() != null)
        composeEnumeration("contextType", element.getContextType(), new Profile().new ExtensionContextEnumFactory());
      for (String_ e : element.getContext()) 
        composeString("context", e);
      composeProfileDefinition("definition", element.getDefinition());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileBinding(String name, Profile.Binding element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      composeString("definition", element.getDefinition());
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new Profile().new BindingTypeEnumFactory());
      composeBoolean("isExtensible", element.getIsExtensible());
      if (element.getConformance() != null)
        composeEnumeration("conformance", element.getConformance(), new Profile().new BindingConformanceEnumFactory());
      composeUri("reference", element.getReference());
      for (Profile.Concept e : element.getConcept()) 
        composeProfileConcept("concept", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileConcept(String name, Profile.Concept element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("code", element.getCode());
      composeUri("system", element.getSystem());
      composeString("display", element.getDisplay());
      composeString("definition", element.getDefinition());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeObservation(String name, Observation element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeCodeableConcept("name", element.getName());
      composeType("value", element.getValue());
      composeCodeableConcept("interpretation", element.getInterpretation());
      composeString("comments", element.getComments());
      composeType("obtained", element.getObtained());
      composeInstant("issued", element.getIssued());
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new Observation().new ObservationStatusEnumFactory());
      if (element.getReliability() != null)
        composeEnumeration("reliability", element.getReliability(), new Observation().new ObservationReliabilityEnumFactory());
      composeCodeableConcept("bodySite", element.getBodySite());
      composeCodeableConcept("method", element.getMethod());
      composeIdentifier("identifier", element.getIdentifier());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("performer", element.getPerformer());
      composeType("normalValue", element.getNormalValue());
      for (Observation.ReferenceRange e : element.getReferenceRange()) 
        composeObservationReferenceRange("referenceRange", e);
      for (Observation.Component e : element.getComponent()) 
        composeObservationComponent("component", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeObservationReferenceRange(String name, Observation.ReferenceRange element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("meaning", element.getMeaning());
      composeType("range", element.getRange());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeObservationComponent(String name, Observation.Component element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("name", element.getName());
      composeType("value", element.getValue());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeImmunization(String name, Immunization element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeResourceReference("subject", element.getSubject());
      composeCodeableConcept("type", element.getType());
      composeDateTime("date", element.getDate());
      composeBoolean("reported", element.getReported());
      composeInteger("doseSequence", element.getDoseSequence());
      composeResourceReference("manufacturer", element.getManufacturer());
      composeString("lotNumber", element.getLotNumber());
      composeDate("expirationDate", element.getExpirationDate());
      composeCodeableConcept("site", element.getSite());
      composeCodeableConcept("route", element.getRoute());
      composeResourceReference("requester", element.getRequester());
      composeResourceReference("performer", element.getPerformer());
      composeImmunizationRefusal("refusal", element.getRefusal());
      for (Immunization.Reaction e : element.getReaction()) 
        composeImmunizationReaction("reaction", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeImmunizationRefusal(String name, Immunization.Refusal element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeDateTime("date", element.getDate());
      composeCodeableConcept("reason", element.getReason());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeImmunizationReaction(String name, Immunization.Reaction element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeDateTime("date", element.getDate());
      composeResourceReference("detail", element.getDetail());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProblem(String name, Problem element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("encounter", element.getEncounter());
      composeResourceReference("asserter", element.getAsserter());
      composeDate("dateAsserted", element.getDateAsserted());
      composeCodeableConcept("code", element.getCode());
      composeCodeableConcept("category", element.getCategory());
      composeCode("status", element.getStatus());
      composeCodeableConcept("certainty", element.getCertainty());
      composeCodeableConcept("severity", element.getSeverity());
      composeType("onset", element.getOnset());
      composeType("abatement", element.getAbatement());
      composeProblemStage("stage", element.getStage());
      for (Problem.Evidence e : element.getEvidence()) 
        composeProblemEvidence("evidence", e);
      for (Problem.Location e : element.getLocation()) 
        composeProblemLocation("location", e);
      for (Problem.RelatedItem e : element.getRelatedItem()) 
        composeProblemRelatedItem("relatedItem", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProblemStage(String name, Problem.Stage element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("summary", element.getSummary());
      for (ResourceReference e : element.getAssessment()) 
        composeResourceReference("assessment", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProblemEvidence(String name, Problem.Evidence element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("code", element.getCode());
      for (ResourceReference e : element.getDetails()) 
        composeResourceReference("details", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProblemLocation(String name, Problem.Location element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("details", element.getDetails());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProblemRelatedItem(String name, Problem.RelatedItem element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new Problem().new ProblemRelationshipTypeEnumFactory());
      composeResourceReference("target", element.getTarget());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeOrderResponse(String name, OrderResponse element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeResourceReference("request", element.getRequest());
      composeDateTime("date", element.getDate());
      composeResourceReference("who", element.getWho());
      composeResourceReference("authority", element.getAuthority());
      composeMoney("cost", element.getCost());
      if (element.getCode() != null)
        composeEnumeration("code", element.getCode(), new OrderResponse().new OrderOutcomeCodeEnumFactory());
      composeString("description", element.getDescription());
      for (ResourceReference e : element.getFulfillment()) 
        composeResourceReference("fulfillment", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composePatient(String name, Patient element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      for (ResourceReference e : element.getLink()) 
        composeResourceReference("link", e);
      composeBoolean("active", element.getActive());
      for (Identifier e : element.getIdentifier()) 
        composeIdentifier("identifier", e);
      composeDemographics("details", element.getDetails());
      composePatientAnimal("animal", element.getAnimal());
      composeResourceReference("provider", element.getProvider());
      composeCodeableConcept("diet", element.getDiet());
      composeCodeableConcept("confidentiality", element.getConfidentiality());
      composeCodeableConcept("recordLocation", element.getRecordLocation());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePatientAnimal(String name, Patient.Animal element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("species", element.getSpecies());
      composeCodeableConcept("breed", element.getBreed());
      composeCodeableConcept("genderStatus", element.getGenderStatus());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeXdsEntry2(String name, XdsEntry2 element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      composeIdentifier("id", element.getId());
      composeDocumentInformation("information", element.getInformation());
      composeCoding("format", element.getFormat());
      if (element.getAvailability() != null)
        composeEnumeration("availability", element.getAvailability(), new XdsEntry2().new XdsEntryAvailabilityEnumFactory());
      for (ResourceReference e : element.getFolder()) 
        composeResourceReference("folder", e);
      composeResourceReference("subject", element.getSubject());
      composeAttachment("content", element.getContent());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProvider(String name, Provider element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      for (Identifier e : element.getIdentifier()) 
        composeIdentifier("identifier", e);
      composeDemographics("details", element.getDetails());
      composeResourceReference("organization", element.getOrganization());
      for (CodeableConcept e : element.getRole()) 
        composeCodeableConcept("role", e);
      for (CodeableConcept e : element.getSpecialty()) 
        composeCodeableConcept("specialty", e);
      composePeriod("period", element.getPeriod());
      for (Address e : element.getAddress()) 
        composeAddress("address", e);
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeXdsFolder(String name, XdsFolder element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      composeResourceAttributes(element);
      xml.open(FHIR_NS, name);
      composeResourceElements(element);
      for (Coding e : element.getCode()) 
        composeCoding("code", e);
      composeString("title", element.getTitle());
      composeIdentifier("patientId", element.getPatientId());
      composeString("homeCommunity", element.getHomeCommunity());
      composeString("comments", element.getComments());
      xml.close(FHIR_NS, name);
    }
  }

  @Override
  protected void composeResource(Resource resource) throws Exception {
    if (resource instanceof CarePlan)
      composeCarePlan("CarePlan", (CarePlan)resource);
    else if (resource instanceof Provenance)
      composeProvenance("Provenance", (Provenance)resource);
    else if (resource instanceof Device)
      composeDevice("Device", (Device)resource);
    else if (resource instanceof Order)
      composeOrder("Order", (Order)resource);
    else if (resource instanceof Organization)
      composeOrganization("Organization", (Organization)resource);
    else if (resource instanceof Prescription)
      composePrescription("Prescription", (Prescription)resource);
    else if (resource instanceof Group)
      composeGroup("Group", (Group)resource);
    else if (resource instanceof ValueSet)
      composeValueSet("ValueSet", (ValueSet)resource);
    else if (resource instanceof Coverage)
      composeCoverage("Coverage", (Coverage)resource);
    else if (resource instanceof Test)
      composeTest("Test", (Test)resource);
    else if (resource instanceof MedicationAdministration)
      composeMedicationAdministration("MedicationAdministration", (MedicationAdministration)resource);
    else if (resource instanceof SecurityEvent)
      composeSecurityEvent("SecurityEvent", (SecurityEvent)resource);
    else if (resource instanceof IssueReport)
      composeIssueReport("IssueReport", (IssueReport)resource);
    else if (resource instanceof List_)
      composeList_("List", (List_)resource);
    else if (resource instanceof LabReport)
      composeLabReport("LabReport", (LabReport)resource);
    else if (resource instanceof Conformance)
      composeConformance("Conformance", (Conformance)resource);
    else if (resource instanceof XdsEntry)
      composeXdsEntry("XdsEntry", (XdsEntry)resource);
    else if (resource instanceof Document)
      composeDocument("Document", (Document)resource);
    else if (resource instanceof Message)
      composeMessage("Message", (Message)resource);
    else if (resource instanceof Profile)
      composeProfile("Profile", (Profile)resource);
    else if (resource instanceof Observation)
      composeObservation("Observation", (Observation)resource);
    else if (resource instanceof Immunization)
      composeImmunization("Immunization", (Immunization)resource);
    else if (resource instanceof Problem)
      composeProblem("Problem", (Problem)resource);
    else if (resource instanceof OrderResponse)
      composeOrderResponse("OrderResponse", (OrderResponse)resource);
    else if (resource instanceof Patient)
      composePatient("Patient", (Patient)resource);
    else if (resource instanceof XdsEntry2)
      composeXdsEntry2("XdsEntry2", (XdsEntry2)resource);
    else if (resource instanceof Provider)
      composeProvider("Provider", (Provider)resource);
    else if (resource instanceof XdsFolder)
      composeXdsFolder("XdsFolder", (XdsFolder)resource);
    else
      throw new Exception("Unhanded resource type "+resource.getClass().getName());
  }

  @SuppressWarnings("unchecked")
  protected void composeType(String prefix, Type type) throws Exception {
    if (type == null)
      ;
    else if (type instanceof Period)
       composePeriod(prefix+"Period", (Period) type);
    else if (type instanceof Coding)
       composeCoding(prefix+"Coding", (Coding) type);
    else if (type instanceof Range)
       composeRange(prefix+"Range", (Range) type);
    else if (type instanceof Quantity)
       composeQuantity(prefix+"Quantity", (Quantity) type);
    else if (type instanceof Choice)
       composeChoice(prefix+"Choice", (Choice) type);
    else if (type instanceof Attachment)
       composeAttachment(prefix+"Attachment", (Attachment) type);
    else if (type instanceof Ratio)
       composeRatio(prefix+"Ratio", (Ratio) type);
    else if (type instanceof ResourceReference)
       composeResourceReference(prefix+"ResourceReference", (ResourceReference) type);
    else if (type instanceof CodeableConcept)
       composeCodeableConcept(prefix+"CodeableConcept", (CodeableConcept) type);
    else if (type instanceof Identifier)
       composeIdentifier(prefix+"Identifier", (Identifier) type);
    else if (type instanceof Age)
       composeAge(prefix+"Age", (Age) type);
    else if (type instanceof Count)
       composeCount(prefix+"Count", (Count) type);
    else if (type instanceof Money)
       composeMoney(prefix+"Money", (Money) type);
    else if (type instanceof Distance)
       composeDistance(prefix+"Distance", (Distance) type);
    else if (type instanceof Duration)
       composeDuration(prefix+"Duration", (Duration) type);
    else if (type instanceof Schedule)
       composeSchedule(prefix+"Schedule", (Schedule) type);
    else if (type instanceof Contact)
       composeContact(prefix+"Contact", (Contact) type);
    else if (type instanceof Address)
       composeAddress(prefix+"Address", (Address) type);
    else if (type instanceof HumanName)
       composeHumanName(prefix+"HumanName", (HumanName) type);
    else if (type instanceof DocumentInformation)
       composeDocumentInformation(prefix+"DocumentInformation", (DocumentInformation) type);
    else if (type instanceof Demographics)
       composeDemographics(prefix+"Demographics", (Demographics) type);
    else if (type instanceof Integer)
       composeInteger(prefix+"Integer", (Integer) type);
    else if (type instanceof DateTime)
       composeDateTime(prefix+"DateTime", (DateTime) type);
    else if (type instanceof Code)
       composeCode(prefix+"Code", (Code) type);
    else if (type instanceof Date)
       composeDate(prefix+"Date", (Date) type);
    else if (type instanceof Decimal)
       composeDecimal(prefix+"Decimal", (Decimal) type);
    else if (type instanceof Uri)
       composeUri(prefix+"Uri", (Uri) type);
    else if (type instanceof Id)
       composeId(prefix+"Id", (Id) type);
    else if (type instanceof Base64Binary)
       composeBase64Binary(prefix+"Base64Binary", (Base64Binary) type);
    else if (type instanceof Oid)
       composeOid(prefix+"Oid", (Oid) type);
    else if (type instanceof String_)
       composeString(prefix+"String", (String_) type);
    else if (type instanceof Boolean)
       composeBoolean(prefix+"Boolean", (Boolean) type);
    else if (type instanceof Uuid)
       composeUuid(prefix+"Uuid", (Uuid) type);
    else if (type instanceof Instant)
       composeInstant(prefix+"Instant", (Instant) type);
    else
      throw new Exception("Unhanded type");
  }

}

