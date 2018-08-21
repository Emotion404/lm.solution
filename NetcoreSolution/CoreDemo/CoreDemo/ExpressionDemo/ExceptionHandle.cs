using System;
using System.Collections.Generic;
using System.Text;
using System.Linq.Expressions;

namespace CoreDemo.ExpressionDemo
{
    public class ExceptionHandle
    {
        public void Exception()
        {
            ParameterExpression ex = Expression.Parameter(typeof(DivideByZeroException));
            Action action = Expression.Lambda<Action>(
                Expression.TryCatch(
                    Expression.Block(
                        Expression.Divide(
                            Expression.Constant(1),
                            Expression.Constant(0)
                            ),
                        Expression.Constant(null)
                        ),
                    Expression.Catch(
                        ex ,
                        Expression.Block(
                            Expression.Call(
                               typeof(Console).GetMethod("WriteLine", new[] { typeof(string) }),
                               Expression.Property(ex, "Message")
                               ),
                            Expression.Constant(null)
                            )
                        )
                    )
                ).Compile();
            action();
        }
    }
}
