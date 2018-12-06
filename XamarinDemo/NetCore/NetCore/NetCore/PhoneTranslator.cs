using System;
using System.Collections.Generic;
using System.Text;

namespace NetCore
{
    public static class PhoneTranslator
    {
        static readonly string[] digits = {
            "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"
        };

        static int? TranslateToNumber(char c)
        {
            for(var i=0;i<digits.Length;i++)
            {
                if(digits[i].Contains(c.ToString()))
                {
                    return 2 + i;
                }
            }
            return null;
        }

        public static string ToNumber(string raw)
        {
            if(string.IsNullOrWhiteSpace(raw))
            {
                return null;
            }
            raw = raw.ToUpperInvariant();
            var newNumber = new StringBuilder();
            foreach(var c in raw)
            {
                if(" -0123456789".Contains(c.ToString()))
                {
                    newNumber.Append(c);
                }
                else
                {
                    var result = TranslateToNumber(c);
                    if(result!=null)
                    {
                        newNumber.Append(c);
                    }
                    else
                    {
                        return null;
                    }
                }
            }
            return newNumber.ToString();
        }
    }
}
