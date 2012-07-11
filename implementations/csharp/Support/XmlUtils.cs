﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;

namespace HL7.Fhir.Instance.Support
{
    public class XmlUtil
    {
        public const string FHIRNS = "http://hl7.org/fhir";
        public const string IDATTR = "id";
        public const string XHTMLNS = "http://www.w3.org/1999/xhtml";
        public const string DIVELEM = "div";
        public static string IDREFATTR = "idref";
        public static string DARATTR = "dataAbsentReason";

        public static string ParseError(XmlReader reader, String text)
        {
            IXmlLineInfo line = (IXmlLineInfo)reader;
          

            return String.Format("At ({0},{1}): {2}", line.LineNumber,
                    line.LinePosition, text);
        }
    }

    [Serializable]
    public class ResourceXmlParseError : Exception
    {
        public ResourceXmlParseError() { }
        public ResourceXmlParseError(string message) : base(message) { }
        public ResourceXmlParseError(string message, Exception inner) : base(message, inner) { }
        protected ResourceXmlParseError(
          System.Runtime.Serialization.SerializationInfo info,
          System.Runtime.Serialization.StreamingContext context)
            : base(info, context) { }
    }
}
