using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;

namespace CoreDemo.AttributesDemo
{
    public class TestAttribute
    {
        public string GetClassAttribute()
        {
            var entity = typeof(DbEntity);
            var attribute = entity.GetCustomAttributes(typeof(NameAttribute), false).FirstOrDefault();
            if(attribute==null)
            {
                return string.Empty;
            }
            return ((NameAttribute)attribute).Name;
        }

        public string GetPropertyAttribute()
        {
            var entity = typeof(DbEntity);
            var fieldInfo = entity.GetField("Address");
            if(fieldInfo==null)
            {
                return string.Empty;
            }
            var attribute = fieldInfo.GetCustomAttributes(typeof(NameAttribute), false).FirstOrDefault();
            if(attribute==null)
            {
                return string.Empty;
            }
            return ((NameAttribute)attribute).Name;
        }

        public (string className,string columnName) TestHelper()
        {
            var m = new DbEntity
            {
                Name = "name_xxx",
                Address = "address_yyy"
            };
            var className = CustomAttributeHelper. GetCustomAttributeValue<DbEntity,NameAttribute>(m,a => a.Name);
            var columnName =CustomAttributeHelper. GetCustomAttributeValue<DbEntity,NameAttribute>(m,a => a.Name, "Address");
            return (className, columnName);
        }
    }
}
