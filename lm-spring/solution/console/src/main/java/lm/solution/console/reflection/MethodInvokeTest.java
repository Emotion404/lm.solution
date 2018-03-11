package lm.solution.console.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvokeTest {

    public double square(double x) {

        return x*x;

    }
    private void printTable(double from, double to, int n, Method f,boolean isStatic){

        //
        System.out.println(f);

        double dx=(to-from)/(n-1);

        //
        for(double x=from;x<=to;x+=dx){

            try {

                double y=0;
                if(isStatic) {
                    y = (Double) f.invoke(null, x);
                }else {
                    y = (Double) f.invoke(this, x);
                }
                System.out.printf("%10.4f | %10.4f%n",x,y);

            }catch (InvocationTargetException | IllegalAccessException e){
                e.printStackTrace();
            }

        }

    }

    /**
     * 利用反射 方法调用
     * */
//    @Test
    public void methodInvokeTest(){

        try {

            Method noneSaticMethod = this.getClass().getMethod("square", double.class);
            Method staticMethod=Math.class.getMethod("sqrt",double.class);

            printTable(1,10,10,noneSaticMethod,false);
            printTable(1,10,10,staticMethod,true);

        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }

    }

}
