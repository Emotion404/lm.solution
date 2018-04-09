package lm.solution.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
/**
 * 通过 @EnableWebSocketMessageBroker 注解开启使用 STOMP 协议来传输基于代理了的消息
 * 这时控制器支持使用 @MessageMapping
 * */
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // 注册 STOMP 协议的节点（endpoint）,并映射指定的 URL ，并指定使用 SockJS 协议
        registry.addEndpoint("/endpointLM")
                .withSockJS();

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){

        // 配置消息代理，并配置一个广播式 消息代理
        registry.enableSimpleBroker("/topic");

    }

}
