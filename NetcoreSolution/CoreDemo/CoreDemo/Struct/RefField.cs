using System;
using System.Collections.Generic;
using System.Text;

namespace CoreDemo.Struct
{
    public class RefField
    {
        public class Ref
        {
            public string Name { get; set; }
        }
        public struct StructX
        {
            public Ref Ref { get; set; }
        }
        public void Test()
        {
            var s1 = new StructX
            {
                Ref = new Ref
                {
                    Name = "张三"
                }
            };
            var s2 = s1;
            s1.Ref.Name = "李四";

            Console.WriteLine(s1.Ref.Name);
            Console.WriteLine(s2.Ref.Name);
        }
    }
}
