﻿/*
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

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Newtonsoft.Json;
using HL7.Fhir.Instance.Model;

namespace HL7.Fhir.Instance.Serializers
{
    public class SerializationUtil
    {
        public static string BuildPolymorphicName(string elementName, Type elementType)
        {
            string typeName = ModelInfo.FhirCsTypeToString[elementType];
            return elementName + Support.Util.Capitalize(typeName);
        }

        public static void SerializeAttributes(JsonWriter writer, Data elem)
        {
            if (elem.ReferralId != null)
            {
                writer.WritePropertyName("_id");
                writer.WriteValue(elem.ReferralId);
            }

            if (elem.Dar.HasValue)
            {
                writer.WritePropertyName("dataAbsentReason");
                writer.WriteValue(EnumHelper.EnumToString(elem.Dar.Value,
                    typeof(DataAbsentReason)));
            }
        }

        public static void SerializeAttributes(IFhirWriter writer, Data elem)
        {
            if (elem.ReferralId != null)
                writer.WriteRefId(elem.ReferralId);

            if (elem.Dar.HasValue)
                writer.WriteDar(EnumHelper.EnumToString(elem.Dar.Value,typeof(DataAbsentReason)));
        }
    }
}
