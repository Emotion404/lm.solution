package lm.solution.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // index
        registry.addViewController("/").setViewName("Index");

        // WebSocket
        registry.addViewController("/websocket/ws").setViewName("websocket/ws");
        registry.addViewController("/websocket/wsqueue").setViewName("websocket/chat");

        /**
         * 页面模板
         * */
        // Bootstrap
        registry.addViewController("/template/bootstrap").setViewName("template/BootstrapStandardTemplate");

    }

}
