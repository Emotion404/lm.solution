using System;
using System.Collections.Generic;
using System.Linq.Expressions;
using System.Text;

namespace CoreDemo.ExpressionDemo
{
    public class HelloWorld
    {
        public void Hello()
        {
            Expression<Action> e = Expression.Lambda<Action>(Expression.Call(typeof(Console).GetMethod("WriteLine", new[] { typeof(string) }), Expression.Constant("Hello Word!")));
            var action = e.Compile();
            action();
        }
    }
}
