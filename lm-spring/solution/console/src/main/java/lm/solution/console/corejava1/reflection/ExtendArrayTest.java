package lm.solution.console.corejava1.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ExtendArrayTest {

    private Object goodCopyOf(Object a,Integer newLength){

        Class cl=a.getClass();

        if(!cl.isArray()){
            return null;
        }

        Class componentType=cl.getComponentType();
        int length= Array.getLength(a);

        Object newArray=Array.newInstance(componentType,newLength);
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));

        return newArray;

    }

    /**
     * 利用反射 扩展数组
     * */
//    @AopTest
    public void extendArray(){

        Integer[] a={1,2,3};
        a=(Integer[])goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));

        String[] b={"xx","yy","zz"};
        b=(String[])goodCopyOf(b,10);
        System.out.println(Arrays.toString(b));

    }

}
