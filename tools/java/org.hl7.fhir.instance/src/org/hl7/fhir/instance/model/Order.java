package org.hl7.fhir.instance.model;

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

import java.util.*;

/**
 * A request to perform an action
 */
public class Order extends Resource {

    public class When extends Element {
        /**
         * Code specifies when request should be done. The code may simply be a priority code
         */
        private CodeableConcept code;

        /**
         * A formal schedule
         */
        private Schedule schedule;

        public CodeableConcept getCode() { 
          return this.code;
        }

        public void setCode(CodeableConcept value) { 
          this.code = value;
        }

        public Schedule getSchedule() { 
          return this.schedule;
        }

        public void setSchedule(Schedule value) { 
          this.schedule = value;
        }

  }

    /**
     * When the order was made
     */
    private DateTime date;

    /**
     * Patient this order is about
     */
    private ResourceReference subject;

    /**
     * Who initiated the order
     */
    private ResourceReference source;

    /**
     * Who is intended to fulfill the order
     */
    private ResourceReference target;

    /**
     * Text - why the order was made
     */
    private String_ reason;

    /**
     * If required by policy
     */
    private ResourceReference authority;

    /**
     * How action is financed (if required)
     */
    private ResourceReference payment;

    /**
     * When order should be filfulled
     */
    private When when;

    /**
     * What action is being ordered
     */
    private List<ResourceReference> detail = new ArrayList<ResourceReference>();

    public DateTime getDate() { 
      return this.date;
    }

    public void setDate(DateTime value) { 
      this.date = value;
    }

    public String getDateSimple() { 
      return this.date.getValue();
    }

    public void setDateSimple(String value) { 
      if (value == null)
        this.date = null;
      else {
        if (this.date == null)
          this.date = new DateTime();
        this.date.setValue(value);
      }
    }

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public ResourceReference getSource() { 
      return this.source;
    }

    public void setSource(ResourceReference value) { 
      this.source = value;
    }

    public ResourceReference getTarget() { 
      return this.target;
    }

    public void setTarget(ResourceReference value) { 
      this.target = value;
    }

    public String_ getReason() { 
      return this.reason;
    }

    public void setReason(String_ value) { 
      this.reason = value;
    }

    public String getReasonSimple() { 
      return this.reason.getValue();
    }

    public void setReasonSimple(String value) { 
      if (value == null)
        this.reason = null;
      else {
        if (this.reason == null)
          this.reason = new String_();
        this.reason.setValue(value);
      }
    }

    public ResourceReference getAuthority() { 
      return this.authority;
    }

    public void setAuthority(ResourceReference value) { 
      this.authority = value;
    }

    public ResourceReference getPayment() { 
      return this.payment;
    }

    public void setPayment(ResourceReference value) { 
      this.payment = value;
    }

    public When getWhen() { 
      return this.when;
    }

    public void setWhen(When value) { 
      this.when = value;
    }

    public List<ResourceReference> getDetail() { 
      return this.detail;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Order;
   }


}

