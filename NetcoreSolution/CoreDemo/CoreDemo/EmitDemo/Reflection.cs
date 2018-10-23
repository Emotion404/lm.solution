using System;
using System.Diagnostics;
using System.Linq.Expressions;
using System.Reflection;
using System.Reflection.Emit;

namespace CoreDemo.EmitDemo
{
    public class User
    {
        public string Username { get; set; }
    }
    delegate void SetValueDelegate(string u);

    public class FastProperty<T>
    {
        public delegate void SetValueDelegateHandler(T ower, object value);
        private readonly Type ParameterType = typeof(object);

        private T _owner;
        public T Owner
        {
            get
            {
                return this._owner;
            }
        }

        private Type _ownerType;

        public FastProperty(T owner)
        {
            this._owner = owner;
            this._ownerType = typeof(T);
        }

        public SetValueDelegateHandler SetPropertyValue(string propertyName,object value)
        {
            var methodName = "set_" + propertyName;  // 指定函数名
            var callMethod = this._ownerType.GetMethod(methodName, BindingFlags.Instance | BindingFlags.IgnoreCase | BindingFlags.Public | BindingFlags.NonPublic);  // 搜索函数，不区分大小写 IgnoreCase
            var para = callMethod.GetParameters()[0];   // 获取参数
            var method = new DynamicMethod("EmitCallable", null, new Type[] { this._ownerType, ParameterType }, this._ownerType.Module);  // 创建动态函数
            var il = method.GetILGenerator();  // 获取动态函数的 IL 生成器
            var local = il.DeclareLocal(para.ParameterType, true);  // 创建一个本地变量，主要用于 Object Type to Propety Type
            il.Emit(OpCodes.Ldarg_1);   // // 加载第 2 个参数【(T owner, object value)】的 value
            if(para.ParameterType.IsValueType)
            {
                il.Emit(OpCodes.Unbox_Any, para.ParameterType);   // 如果是值类型，拆箱 int = (int)object;
            }
            else
            {
                il.Emit(OpCodes.Castclass, para.ParameterType);   // 如果是引用类型，转换 Class = object as Class
            }
            il.Emit(OpCodes.Stloc, local);  //  将上面的拆箱或转换，赋值到本地变量，现在这个本地变量是一个与目标函数相同数据类型的字段了。
            il.Emit(OpCodes.Ldarg_0);  // 加载第一个参数 owner
            il.Emit(OpCodes.Ldloc, local);  // 加载本地参数
            il.EmitCall(OpCodes.Callvirt, callMethod, null);  //调用函数
            il.Emit(OpCodes.Ret);  // 返回

            return method.CreateDelegate(typeof(SetValueDelegateHandler)) as SetValueDelegateHandler;
        }
    }

    public class Reflection
    {

        public void work1_10000()
        {
            var watch = new Stopwatch();
            watch.Start();
            for (var i = 0; i < 10000; i++)
            {
                User u = new User();

                var methodName = "set_Username";  // 获取函数（命名约束）
                var method = u.GetType().GetMethod(methodName);  // 查找函数
                var type = method.GetParameters()[0].ParameterType;  // 返回第一个参数的数据类型

                var parameter = Expression.Parameter(type, "value");  // 创建一个表达式参数
                var callExpression = Expression.Call(Expression.Constant(u), method, parameter);  // 创建指定 实例、函数、参数 的调用函数

                var lambdaExpression = Expression.Lambda<SetValueDelegate>(callExpression, parameter);  // 创建调用函数的表达式
                var dd = lambdaExpression.Compile();
                
                dd("hello!");
            }
            watch.Stop();
            Console.WriteLine("work1_10000 Linq Expression：\t{0}", watch.Elapsed.ToString());

        }

        public void work2_10000()
        {

        }

    }
}
