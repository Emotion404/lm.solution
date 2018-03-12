package lm.solution.console.lambda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AnonymousInnerClassTest {

//    @Test
    public void anonymousInnerClassTest(){

        TalkingClock clock=new TalkingClock();
        clock.start(1000,true);



    }

}

class TalkingClock{

    public void start(int interval,boolean beep){

        ActionListener listener=new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {

                System.out.println("At the tone,the time is "+new Date());
                if(beep){
                    Toolkit.getDefaultToolkit().beep();
                }

            }

        };

        Timer t=new Timer(interval,listener);
        t.start();

    }

}
