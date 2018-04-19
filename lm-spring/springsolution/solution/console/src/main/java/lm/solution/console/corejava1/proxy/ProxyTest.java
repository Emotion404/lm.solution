package lm.solution.console.corejava1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {

    /**
     * 方法代理 -- 由实现InvocationHandler接口的子类代理Comparable接口方法的执行
     * */
//    @Test
    public void proxyClassTest(){

        Object[] elements=new Object[1000];

        //
        for(int i=0;i<elements.length;i++){
            Integer value=i+1;
            InvocationHandler handler=new TraceHandler(value);
            Object proxy= Proxy.newProxyInstance(null,new Class[]{Comparable.class},handler);
            elements[i]=proxy;
        }

        //
        Integer key=new Random().nextInt(elements.length)+1;

        //
        int result= Arrays.binarySearch(elements,key);

        if(result>=0){
            System.out.println(elements[result]);
        }

    }

}

class TraceHandler implements InvocationHandler{

    private Object target;

    public TraceHandler(Object target){

        this.target=target;

    }

    public Object invoke(Object proxy, Method m,Object[] args) throws Throwable{

        System.out.print(target);
        System.out.print("."+m.getName()+"(");
        if(args!=null){
            for (int i=0;i<args.length;i++){
                System.out.print(args[i]);
                if(i<args.length-1){
                    System.out.print(", ");
                }
            }
        }
        System.out.println(")");

        // 调用实际方法
        return m.invoke(target,args);

    }

}
