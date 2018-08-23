using System;
using System.Collections.Generic;
using System.Linq.Expressions;
using System.Reflection;
using System.Text;

namespace CoreDemo.ExpressionDemo
{
    public class MemberExpre
    {
        public void TestMemberAccess()
        {
            var foo = new Foo
            {
                Bar = "123"
            };

            Expression<Func<string>> func = () => foo.Bar;

            Test(func);
        }

        private void Test(Expression<Func<string>> func)
        {
            MemberExpression outerMember = func.Body as MemberExpression;
            PropertyInfo prop = outerMember.Member as PropertyInfo;

            MemberExpression innerMember = outerMember.Expression as MemberExpression;
            FieldInfo innerField = innerMember.Member as FieldInfo;

            ConstantExpression ce = innerMember.Expression as ConstantExpression;

            object innerObj = ce.Value;
            object outerObj = innerField.GetValue(innerObj);

            string value = prop.GetValue(outerObj, null).ToString();
        }
    }
}
