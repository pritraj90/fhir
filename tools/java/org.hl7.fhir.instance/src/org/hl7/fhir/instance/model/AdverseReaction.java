package org.hl7.fhir.instance.model;

/*
  Copyright (c) 2011-2013, HL7, Inc.
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

// Generated on Sun, Apr 14, 2013 21:55+1000 for FHIR v0.08

import java.util.*;

/**
 * AdverseReaction
 */
public class AdverseReaction extends Resource {

    public enum ReactionSeverity {
        severe, // Severe complications arose due to the reaction
        serious, // Serious inconvience to the subject
        moderate, // Moderate inconvience to the subject
        minor, // Minor inconvience to the subject
        Null; // added to help the parsers
        public static ReactionSeverity fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("severe".equals(codeString))
          return severe;
        if ("serious".equals(codeString))
          return serious;
        if ("moderate".equals(codeString))
          return moderate;
        if ("minor".equals(codeString))
          return minor;
        throw new Exception("Unknown ReactionSeverity code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case severe: return "severe";
            case serious: return "serious";
            case moderate: return "moderate";
            case minor: return "minor";
            default: return "?";
          }
        }
    }

  public class ReactionSeverityEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("severe".equals(codeString))
          return ReactionSeverity.severe;
        if ("serious".equals(codeString))
          return ReactionSeverity.serious;
        if ("moderate".equals(codeString))
          return ReactionSeverity.moderate;
        if ("minor".equals(codeString))
          return ReactionSeverity.minor;
        throw new Exception("Unknown ReactionSeverity code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == ReactionSeverity.severe)
        return "severe";
      if (code == ReactionSeverity.serious)
        return "serious";
      if (code == ReactionSeverity.moderate)
        return "moderate";
      if (code == ReactionSeverity.minor)
        return "minor";
      return "?";
      }
    }

    public enum ExposureType {
        drugadmin, // Drug Administration
        immuniz, // Immunization
        coincidental, // In the same area as the substance
        Null; // added to help the parsers
        public static ExposureType fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("drugadmin".equals(codeString))
          return drugadmin;
        if ("immuniz".equals(codeString))
          return immuniz;
        if ("coincidental".equals(codeString))
          return coincidental;
        throw new Exception("Unknown ExposureType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case drugadmin: return "drugadmin";
            case immuniz: return "immuniz";
            case coincidental: return "coincidental";
            default: return "?";
          }
        }
    }

  public class ExposureTypeEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("drugadmin".equals(codeString))
          return ExposureType.drugadmin;
        if ("immuniz".equals(codeString))
          return ExposureType.immuniz;
        if ("coincidental".equals(codeString))
          return ExposureType.coincidental;
        throw new Exception("Unknown ExposureType code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == ExposureType.drugadmin)
        return "drugadmin";
      if (code == ExposureType.immuniz)
        return "immuniz";
      if (code == ExposureType.coincidental)
        return "coincidental";
      return "?";
      }
    }

    public class AdverseReactionSymptomComponent extends Element {
        /**
         * A code that indicates the specific sign or symptom that was observed
         */
        private CodeableConcept code;

        /**
         * The severity of the sign or symptom
         */
        private Enumeration<ReactionSeverity> severity;

        public CodeableConcept getCode() { 
          return this.code;
        }

        public void setCode(CodeableConcept value) { 
          this.code = value;
        }

        public Enumeration<ReactionSeverity> getSeverity() { 
          return this.severity;
        }

        public void setSeverity(Enumeration<ReactionSeverity> value) { 
          this.severity = value;
        }

        public ReactionSeverity getSeveritySimple() { 
          return this.severity == null ? null : this.severity.getValue();
        }

        public void setSeveritySimple(ReactionSeverity value) { 
          if (value == null)
            this.severity = null;
          else {
            if (this.severity == null)
              this.severity = new Enumeration<ReactionSeverity>();
            this.severity.setValue(value);
          }
        }

  }

    public class AdverseReactionExposureComponent extends Element {
        /**
         * When the exposure occurred
         */
        private DateTime exposureDate;

        /**
         * Drug Administration, Immunization, Coincidental
         */
        private Enumeration<ExposureType> exposureType;

        /**
         * The substance that the subject was exposed to
         */
        private ResourceReference substance;

        public DateTime getExposureDate() { 
          return this.exposureDate;
        }

        public void setExposureDate(DateTime value) { 
          this.exposureDate = value;
        }

        public String getExposureDateSimple() { 
          return this.exposureDate == null ? null : this.exposureDate.getValue();
        }

        public void setExposureDateSimple(String value) { 
          if (value == null)
            this.exposureDate = null;
          else {
            if (this.exposureDate == null)
              this.exposureDate = new DateTime();
            this.exposureDate.setValue(value);
          }
        }

        public Enumeration<ExposureType> getExposureType() { 
          return this.exposureType;
        }

        public void setExposureType(Enumeration<ExposureType> value) { 
          this.exposureType = value;
        }

        public ExposureType getExposureTypeSimple() { 
          return this.exposureType == null ? null : this.exposureType.getValue();
        }

        public void setExposureTypeSimple(ExposureType value) { 
          if (value == null)
            this.exposureType = null;
          else {
            if (this.exposureType == null)
              this.exposureType = new Enumeration<ExposureType>();
            this.exposureType.setValue(value);
          }
        }

        public ResourceReference getSubstance() { 
          return this.substance;
        }

        public void setSubstance(ResourceReference value) { 
          this.substance = value;
        }

  }

    /**
     * When the reaction occurred
     */
    private DateTime reactionDate;

    /**
     * The subject of the adverse reaction
     */
    private ResourceReference subject;

    /**
     * The substance that is presumed to have caused the reaction
     */
    private ResourceReference substance;

    /**
     * Used to record evidence that a reaction to a substance did not occur
     */
    private Boolean didNotOccurFlag;

    /**
     * Who recorded the reaction
     */
    private ResourceReference recorder;

    /**
     * The signs and symptoms that were observed as part of the reaction
     */
    private List<AdverseReactionSymptomComponent> symptom = new ArrayList<AdverseReactionSymptomComponent>();

    /**
     * An exposure to a substance that preceded a reaction occurrence
     */
    private List<AdverseReactionExposureComponent> exposure = new ArrayList<AdverseReactionExposureComponent>();

    public DateTime getReactionDate() { 
      return this.reactionDate;
    }

    public void setReactionDate(DateTime value) { 
      this.reactionDate = value;
    }

    public String getReactionDateSimple() { 
      return this.reactionDate == null ? null : this.reactionDate.getValue();
    }

    public void setReactionDateSimple(String value) { 
      if (value == null)
        this.reactionDate = null;
      else {
        if (this.reactionDate == null)
          this.reactionDate = new DateTime();
        this.reactionDate.setValue(value);
      }
    }

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public ResourceReference getSubstance() { 
      return this.substance;
    }

    public void setSubstance(ResourceReference value) { 
      this.substance = value;
    }

    public Boolean getDidNotOccurFlag() { 
      return this.didNotOccurFlag;
    }

    public void setDidNotOccurFlag(Boolean value) { 
      this.didNotOccurFlag = value;
    }

    public boolean getDidNotOccurFlagSimple() { 
      return this.didNotOccurFlag == null ? null : this.didNotOccurFlag.getValue();
    }

    public void setDidNotOccurFlagSimple(boolean value) { 
      if (value == false)
        this.didNotOccurFlag = null;
      else {
        if (this.didNotOccurFlag == null)
          this.didNotOccurFlag = new Boolean();
        this.didNotOccurFlag.setValue(value);
      }
    }

    public ResourceReference getRecorder() { 
      return this.recorder;
    }

    public void setRecorder(ResourceReference value) { 
      this.recorder = value;
    }

    public List<AdverseReactionSymptomComponent> getSymptom() { 
      return this.symptom;
    }

    public List<AdverseReactionExposureComponent> getExposure() { 
      return this.exposure;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.AdverseReaction;
   }


}
