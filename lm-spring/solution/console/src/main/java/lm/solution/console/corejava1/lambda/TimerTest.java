package lm.solution.console.corejava1.lambda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerTest implements ActionListener {

    /* test 不可以 */
//    @Test
    public void timePrintTest(){

        ActionListener listener=new TimerTest();

        Timer t=new Timer(3000,listener);
        t.start();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("At the tone,the time is "+new Date());
        Toolkit.getDefaultToolkit().beep();

    }



}
