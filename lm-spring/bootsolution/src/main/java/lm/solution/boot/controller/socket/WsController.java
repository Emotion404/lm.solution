package lm.solution.boot.controller.socket;

import lm.solution.boot.entity.websocket.WiselyMessage;
import lm.solution.boot.entity.websocket.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;

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

    // 通过 SimpMessagingTemplate 向浏览器发送消息
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Spring MVC 中可以直接在参数中获得 principal , principal 中包含当前用户信息
    @MessageMapping("/socket/chat")
    public void handleChat(Principal principal,@RequestBody String msg){

        if(principal.getName().equals("wyf")){
            messagingTemplate.convertAndSendToUser(
                    "wisely",   // 接收消息的用户
                    "/queue/notifications",  //  浏览器订阅的地址
                    principal.getName()+"-send:"+msg);   // 消息本身
        }else {
            messagingTemplate.convertAndSendToUser(
                    "wyf",
                    "/queue/notifications",
                    principal.getName()+"-send:"+msg);
        }

    }

}
