package lm.solution.common.imagecode;

import java.awt.*;
import java.util.Random;

public class ColorHelper {

    // 创建颜色
    public Color getRandColor(int fc, int bc){

        Random random=new Random();
        if(fc>255){
            fc=255;
        }
        if(bc>255){
            bc=255;
        }
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return  new Color(r,g,b);

    }

}
