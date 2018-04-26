package lm.solution.web.config.beans;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import lm.solution.web.config.exceptions.SpringHandlerExceptionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
public class HandlerBean {

    @Bean
    public FastJsonConfig fastJsonConfig(){

        return new FastJsonConfig();

    }

    @Bean
    public HandlerExceptionResolver handlerExceptionResolver(FastJsonConfig config){

        return new SpringHandlerExceptionResolver(config);

    }

}
