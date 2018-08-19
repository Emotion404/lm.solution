using System;
using System.Collections.Generic;
using System.Text;

namespace CoreDemo.AttributesDemo
{
    [Name("TableName")]
    public class DbEntity: IEntity
    {
        [Name("NameColumn")]
        public string Name { get; set; }

        [Name("AddressColumn")]
        public string Address { get; set; }

    }
}
