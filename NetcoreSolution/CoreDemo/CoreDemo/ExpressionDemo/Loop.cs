using System;
using System.Collections.Generic;
using System.Text;
using System.Linq.Expressions;

namespace CoreDemo.ExpressionDemo
{
    public class Loop
    {

        public void TestFor()
        {
            ParameterExpression localvar_sequence = Expression.Parameter(typeof(int));
            LabelTarget break_label = Expression.Label(typeof(int));
            LabelTarget continue_label = Expression.Label(typeof(void));

            Func<int> func = Expression.Lambda<Func<int>>(
                Expression.Block(
                   new ParameterExpression[]
                   {
                       localvar_sequence
                   },
                   new Expression[]
                   {
                       Expression.Assign(localvar_sequence,Expression.Constant(0)),
                       Expression.Loop(
                           Expression.IfThenElse(
                               Expression.LessThan(
                                   localvar_sequence,
                                   Expression.Constant(100)
                                   ),
                                   Expression.Block(
                                       Expression.AddAssign(localvar_sequence,Expression.Constant(1)),
                                       Expression.Call(typeof(Console).GetMethod("WriteLine", new Type[]{ typeof(int)}),localvar_sequence),
                                       Expression.Continue(continue_label,typeof(void))
                                       ),
                                   Expression.Break(break_label,localvar_sequence)  // return 
                               ),
                                   break_label,
                                   continue_label
                           )
                   })
                ).Compile();
            Console.WriteLine(func());
        }

    }
}
