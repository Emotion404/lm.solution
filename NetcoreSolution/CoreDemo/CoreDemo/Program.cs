using CoreDemo.AttributesDemo;
using CoreDemo.EmitDemo;
using CoreDemo.ExpressionDemo;
using System;

namespace CoreDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            /*
             * EmitDemo
             */
            {
                var test = new TestEmit();
                test.HelloWorld();
            }

            /*
             * ExpressionDemo
             */
            {
                //var test = new TestExpression();
                //test.TestHello();
                //test.TestListMakeIndex();
                //test.TestException();
                //test.TestLoop();
                //test.TestMemberAccess();
            }

            /*
             * AttributesDemo
             */
            {
                //var test = new TestAttribute();
                //var className = test.GetClassAttribute();
                //var columnName = test.GetPropertyAttribute();
                //var tuple = test.TestHelper();
            }

        }
    }
}
