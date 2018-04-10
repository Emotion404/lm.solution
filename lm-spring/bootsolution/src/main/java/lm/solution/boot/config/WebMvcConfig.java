package lm.solution.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // WebSocket
        registry.addViewController("/websocket/ws").setViewName("ws");
        registry.addViewController("/websocket/wsqueue").setViewName("chat");

        // Spring Security
        registry.addViewController("/login").setViewName("login");

        // Bootstrap
        registry.addViewController("/template/bootstrap").setViewName("BootstrapStandardTemplate");

    }

}
