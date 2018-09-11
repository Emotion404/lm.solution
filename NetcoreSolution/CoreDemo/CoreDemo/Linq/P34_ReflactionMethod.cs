using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CoreDemo.Linq
{
    public class P34_ReflactionMethod
    {

        public void ReflactionMethodInLinq()
        {
            var query =
                from assembly in AppDomain.CurrentDomain.GetAssemblies()
                from type in assembly.GetTypes()
                from method in type.GetMethods()
                where method.IsStatic && method.ReturnType.GetInterface("IEnumerable`1") != null
                orderby method.DeclaringType.Name, method.Name
                group method by new {Class = method.DeclaringType, Method = method.Name}
                ;

            foreach (var m in query.ToList())
            {
                foreach (var n in m)
                {
                    Console.WriteLine($"{n}");
                }
            }

        }

        public void RelactionMethod()
        {
            var results = new List<string>();
            foreach (var assmbly in AppDomain.CurrentDomain.GetAssemblies())
            {
                foreach (var type in assmbly.GetTypes())
                {
                    foreach (var method in type.GetMethods())
                    {
                        if (method.IsStatic
                            && method.ReturnType.GetInterface("IEnumerable`1") != null)
                        {
                            string fullName = string.Format($"{method.DeclaringType.FullName}.{method.Name}");
                            if (results.IndexOf(fullName) < 0)
                            {
                                results.Add(fullName);
                            }
                        }
                    }
                }
            }

            results.Sort();

            foreach (var item in results)
            {
                Console.WriteLine(item);
            }
        }

    }
}
