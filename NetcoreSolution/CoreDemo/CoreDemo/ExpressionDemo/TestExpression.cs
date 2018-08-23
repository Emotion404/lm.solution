using System;
using System.Collections.Generic;
using System.Text;

namespace CoreDemo.ExpressionDemo
{
    public class TestExpression
    {
        public void TestHello()
        {
            new HelloWorld().Hello();
        }

        public void TestListMakeIndex()
        {
            new List_MakeIndex().LP();
        }

        public void TestException()
        {
            new ExceptionHandle().Exception();
        }

        public void TestLoop()
        {
            new Loop().TestFor();
        }

        public void TestMemberAccess()
        {
            new MemberExpre().TestMemberAccess();
        }
    }
}
