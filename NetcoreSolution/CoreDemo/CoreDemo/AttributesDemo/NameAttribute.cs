using System;
using System.Collections.Generic;
using System.Text;

namespace CoreDemo.AttributesDemo
{
    [AttributeUsage(AttributeTargets.All)]
    public sealed class NameAttribute : Attribute
    {
        private readonly string _name;

        public string Name
        {
            get
            {
                return _name;
            }
        }

        public NameAttribute(string name)
        {
            _name = name;
        }



    }
}
