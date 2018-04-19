package lm.solution.console.corejava1.lambda;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

public class ArraySortTest {

//    @Test
    public void lambdaSortTest(){

        String[] planets=new String[] {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
        System.out.println(Arrays.toString(planets));

        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        // 自动 推断类型
        Arrays.sort(planets,(first,second)->{

            return first.length()-second.length();

        });
        System.out.println(Arrays.toString(planets));

        Timer t=new Timer(1000,event->{
            System.out.println("The time is "+new Date());
        });
        t.start();

    }

}
