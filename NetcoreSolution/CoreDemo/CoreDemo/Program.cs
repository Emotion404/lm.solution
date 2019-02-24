using CoreDemo.AttributesDemo;
using CoreDemo.EmitDemo;
using CoreDemo.ExpressionDemo;
using System;
using CoreDemo.AdoNet;
using CoreDemo.Linq;
using CoreDemo.Weixin;
using CoreDemo.Struct;

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
                //test.HelloWorld();
                //test.ReflactionWork10000();
            }

            /*
             * Linq
             */
            {
                var test = new TestLinq();
                //test.P34TestRelactionMethod();
            }

            /*
             * Ado.Net
             */
            {
                var test = new TestAdoNet();
                //test.TestPoll();   //  无法运行
                //test.testFirstOrDefault();
            }


            /*
             * ExpressionDemo
             */
            {
                var test = new TestExpression();
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
                var test = new TestAttribute();
                //var className = test.GetClassAttribute();
                //var columnName = test.GetPropertyAttribute();
                //var tuple = test.TestHelper();
            }


            /*
             * WeiXin
             */
            // new AccessTokenTest().AccessTokenCon();


            /*
             * Struct  
             */
            {
                var test = new RefField();
                test.Test();

            }

            Console.ReadLine();
        }
    }
}
