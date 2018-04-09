package lm.solution.boot.controller.socket;

import lm.solution.boot.entity.websocket.WiselyMessage;
import lm.solution.boot.entity.websocket.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {

    // 浏览器端 向 服务端 发送请求时， 通过 @MessageMapping 映射 “/socket/welcome”
    @MessageMapping("/socket/welcome")
    // 当服务端有消息时 ，会对订阅了 @SendTo 路径的浏览器发送消息
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message)
        throws Exception{

        Thread.sleep(3000);
        return new WiselyResponse("web socket msg: Welcome "+message.getName()+"!");

    }

}
