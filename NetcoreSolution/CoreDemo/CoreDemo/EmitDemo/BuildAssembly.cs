using System;
using System.Collections.Generic;
using System.Reflection;
using System.Reflection.Emit;
using System.Text;

namespace CoreDemo.EmitDemo
{
    public class BuildAssembly
    {

        public void HelloWorld()
        {
            // 创建程序集
            var asm = new AssemblyName("Test");
            var asmBuilder = AssemblyBuilder.DefineDynamicAssembly(asm, AssemblyBuilderAccess.Run);

            // 创建模块
            var modBuilder = asmBuilder.DefineDynamicModule("Main");

            // 定义类
            var typeBuilder = modBuilder.DefineType("Hello", TypeAttributes.Public);

            // 定义方法
            var methodBuilder = typeBuilder.DefineMethod("SayHello", MethodAttributes.Public, null, null);

            // Console.WriteLine("Hello,World")
            var il = methodBuilder.GetILGenerator();  // 获取il生成器 
            il.Emit(OpCodes.Ldstr, "Hello, World");  // ldStr:加载一个字符串到 evaluation stack。
            il.Emit(OpCodes.Call, typeof(Console).GetMethod("WriteLine", new Type[] { typeof(string) }));  // Call:调用方法。
            il.Emit(OpCodes.Ret);  // Ret:返回，当evaluation stack有值时会返回栈顶值。

            // 完成类创建
            var t = typeBuilder.CreateType();

        }

    }
}
