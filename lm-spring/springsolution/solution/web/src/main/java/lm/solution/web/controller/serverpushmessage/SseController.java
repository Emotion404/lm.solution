package lm.solution.web.controller.serverpushmessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class SseController {

    /**
     * 输出的媒体类型 text/event-stream ，
     * 这是服务器端 SSE 的支持
     * */
    @RequestMapping(value = "/ServerSendMsg/push" ,produces = "text/event-stream")
    @ResponseBody
    public String push(){

        Random random=new Random();
        try{
            /**
             * 每 5s 向浏览器推送一次消息
             * */
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "data:Testing 1,2,3,"+ random.nextInt()+"\n\n";

    }

}
