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

import java.math.*;
/**
 * A schedule that specifies an event that may occur multiple times. Schedules are not used for recording when things did happen, but when they are expected or requested to occur.
 */
public class Schedule extends Type {

    public enum EventTiming {
        HS, // event occurs [duration] before the hour of sleep (or trying to)
        WAKE, // event occurs [duration] after waking
        AC, // event occurs [duration] before a meal (from the Latin ante cibus)
        ACM, // event occurs [duration] before breakfast (from the Latin ante cibus matutinus)
        ACD, // event occurs [duration] before lunch (from the Latin ante cibus diurnus)
        ACV, // event occurs [duration] before dinner (from the Latin ante cibus vespertinus)
        PC, // event occurs [duration] after a meal (from the Latin post cibus)
        PCM, // event occurs [duration] after breakfast (from the Latin post cibus matutinus)
        PCD, // event occurs [duration] after lunch (from the Latin post cibus diurnus)
        PCV, // event occurs [duration] after dinner (from the Latin post cibus vespertinus) 
        Null; // added to help the parsers
        public static EventTiming fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("HS".equals(codeString))
          return HS;
        if ("WAKE".equals(codeString))
          return WAKE;
        if ("AC".equals(codeString))
          return AC;
        if ("ACM".equals(codeString))
          return ACM;
        if ("ACD".equals(codeString))
          return ACD;
        if ("ACV".equals(codeString))
          return ACV;
        if ("PC".equals(codeString))
          return PC;
        if ("PCM".equals(codeString))
          return PCM;
        if ("PCD".equals(codeString))
          return PCD;
        if ("PCV".equals(codeString))
          return PCV;
        throw new Exception("Unknown EventTiming code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case HS: return "HS";
            case WAKE: return "WAKE";
            case AC: return "AC";
            case ACM: return "ACM";
            case ACD: return "ACD";
            case ACV: return "ACV";
            case PC: return "PC";
            case PCM: return "PCM";
            case PCD: return "PCD";
            case PCV: return "PCV";
            default: return "?";
          }
        }
    }

  public class EventTimingEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("HS".equals(codeString))
          return EventTiming.HS;
        if ("WAKE".equals(codeString))
          return EventTiming.WAKE;
        if ("AC".equals(codeString))
          return EventTiming.AC;
        if ("ACM".equals(codeString))
          return EventTiming.ACM;
        if ("ACD".equals(codeString))
          return EventTiming.ACD;
        if ("ACV".equals(codeString))
          return EventTiming.ACV;
        if ("PC".equals(codeString))
          return EventTiming.PC;
        if ("PCM".equals(codeString))
          return EventTiming.PCM;
        if ("PCD".equals(codeString))
          return EventTiming.PCD;
        if ("PCV".equals(codeString))
          return EventTiming.PCV;
        throw new Exception("Unknown EventTiming code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == EventTiming.HS)
        return "HS";
      if (code == EventTiming.WAKE)
        return "WAKE";
      if (code == EventTiming.AC)
        return "AC";
      if (code == EventTiming.ACM)
        return "ACM";
      if (code == EventTiming.ACD)
        return "ACD";
      if (code == EventTiming.ACV)
        return "ACV";
      if (code == EventTiming.PC)
        return "PC";
      if (code == EventTiming.PCM)
        return "PCM";
      if (code == EventTiming.PCD)
        return "PCD";
      if (code == EventTiming.PCV)
        return "PCV";
      return "?";
      }
    }

    public enum UnitsOfTime {
        s, // second
        min, // minute
        h, // hour
        d, // day
        wk, // week
        mo, // month
        a, // year
        Null; // added to help the parsers
        public static UnitsOfTime fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("s".equals(codeString))
          return s;
        if ("min".equals(codeString))
          return min;
        if ("h".equals(codeString))
          return h;
        if ("d".equals(codeString))
          return d;
        if ("wk".equals(codeString))
          return wk;
        if ("mo".equals(codeString))
          return mo;
        if ("a".equals(codeString))
          return a;
        throw new Exception("Unknown UnitsOfTime code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case s: return "s";
            case min: return "min";
            case h: return "h";
            case d: return "d";
            case wk: return "wk";
            case mo: return "mo";
            case a: return "a";
            default: return "?";
          }
        }
    }

  public class UnitsOfTimeEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("s".equals(codeString))
          return UnitsOfTime.s;
        if ("min".equals(codeString))
          return UnitsOfTime.min;
        if ("h".equals(codeString))
          return UnitsOfTime.h;
        if ("d".equals(codeString))
          return UnitsOfTime.d;
        if ("wk".equals(codeString))
          return UnitsOfTime.wk;
        if ("mo".equals(codeString))
          return UnitsOfTime.mo;
        if ("a".equals(codeString))
          return UnitsOfTime.a;
        throw new Exception("Unknown UnitsOfTime code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == UnitsOfTime.s)
        return "s";
      if (code == UnitsOfTime.min)
        return "min";
      if (code == UnitsOfTime.h)
        return "h";
      if (code == UnitsOfTime.d)
        return "d";
      if (code == UnitsOfTime.wk)
        return "wk";
      if (code == UnitsOfTime.mo)
        return "mo";
      if (code == UnitsOfTime.a)
        return "a";
      return "?";
      }
    }

    public class Repeat extends Element {
        /**
         * Indicates how often the event should occur.
         */
        private Integer frequency;

        /**
         * Identifies the occurrence of daily life that determine timing
         */
        private Enumeration<EventTiming> when;

        /**
         * How long each repetition should last
         */
        private Decimal duration;

        /**
         * the units of time for the duration
         */
        private Enumeration<UnitsOfTime> units;

        /**
         * A total count of the desired number of repetitions
         */
        private Integer count;

        /**
         * When to stop repeats
         */
        private DateTime end;

        public Integer getFrequency() { 
          return this.frequency;
        }

        public void setFrequency(Integer value) { 
          this.frequency = value;
        }

        public int getFrequencySimple() { 
          return this.frequency.getValue();
        }

        public void setFrequencySimple(int value) { 
          if (value == -1)
            this.frequency = null;
          else {
            if (this.frequency == null)
              this.frequency = new Integer();
            this.frequency.setValue(value);
          }
        }

        public Enumeration<EventTiming> getWhen() { 
          return this.when;
        }

        public void setWhen(Enumeration<EventTiming> value) { 
          this.when = value;
        }

        public EventTiming getWhenSimple() { 
          return this.when.getValue();
        }

        public void setWhenSimple(EventTiming value) { 
          if (value == null)
            this.when = null;
          else {
            if (this.when == null)
              this.when = new Enumeration<EventTiming>();
            this.when.setValue(value);
          }
        }

        public Decimal getDuration() { 
          return this.duration;
        }

        public void setDuration(Decimal value) { 
          this.duration = value;
        }

        public BigDecimal getDurationSimple() { 
          return this.duration.getValue();
        }

        public void setDurationSimple(BigDecimal value) { 
          if (value == null)
            this.duration = null;
          else {
            if (this.duration == null)
              this.duration = new Decimal();
            this.duration.setValue(value);
          }
        }

        public Enumeration<UnitsOfTime> getUnits() { 
          return this.units;
        }

        public void setUnits(Enumeration<UnitsOfTime> value) { 
          this.units = value;
        }

        public UnitsOfTime getUnitsSimple() { 
          return this.units.getValue();
        }

        public void setUnitsSimple(UnitsOfTime value) { 
          if (value == null)
            this.units = null;
          else {
            if (this.units == null)
              this.units = new Enumeration<UnitsOfTime>();
            this.units.setValue(value);
          }
        }

        public Integer getCount() { 
          return this.count;
        }

        public void setCount(Integer value) { 
          this.count = value;
        }

        public int getCountSimple() { 
          return this.count.getValue();
        }

        public void setCountSimple(int value) { 
          if (value == -1)
            this.count = null;
          else {
            if (this.count == null)
              this.count = new Integer();
            this.count.setValue(value);
          }
        }

        public DateTime getEnd() { 
          return this.end;
        }

        public void setEnd(DateTime value) { 
          this.end = value;
        }

        public String getEndSimple() { 
          return this.end.getValue();
        }

        public void setEndSimple(String value) { 
          if (value == null)
            this.end = null;
          else {
            if (this.end == null)
              this.end = new DateTime();
            this.end.setValue(value);
          }
        }

  }

    /**
     * Identifies specific time periods when the event should occur
     */
    private List<Period> event = new ArrayList<Period>();

    /**
     * Identifies a repeating pattern to the intended time periods. 
     */
    private Repeat repeat;

    public List<Period> getEvent() { 
      return this.event;
    }

    public Repeat getRepeat() { 
      return this.repeat;
    }

    public void setRepeat(Repeat value) { 
      this.repeat = value;
    }


}

