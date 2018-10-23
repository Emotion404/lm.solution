using System;
using System.Collections.Generic;
using System.Text;

namespace CoreDemo.EmitDemo
{
    public class TestEmit
    {
        public void HelloWorld()
        {
            new BuildAssembly().HelloWorld();
        }

        public void ReflactionWork10000()
        {
            new Reflection().work1_10000();
        }
    }
}
