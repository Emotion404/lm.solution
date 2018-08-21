using System;
using System.Collections.Generic;
using System.Linq.Expressions;
using System.Text;

namespace CoreDemo.ExpressionDemo
{
    public class List_MakeIndex
    {

        public void LP()
        {
            ParameterExpression param = Expression.Parameter(typeof(IList<string>));
            Action<IList<string>> action = Expression.Lambda<Action<IList<string>>>((
                Expression.Assign(
                    Expression.MakeIndex(
                        param,
                        typeof(IList<string>).GetProperty("Item"),
                        new[] { Expression.Constant(0) }),
                    Expression.Constant("you just fadded away"))
                ),
                param
                ).Compile();
            string[] arrStr = new string[] { "A Place Nearby" };
            action(arrStr);
            Console.WriteLine(arrStr[0]);
        }

    }
}
