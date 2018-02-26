package lm.solution.web.config.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("lm.solution")
public class WebConfig extends WebMvcConfigurerAdapter {

    // 配置JSP视图解析器
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setContentType("text/html");
        // 前缀
        resolver.setPrefix("/WEB-INF/views/");
        // 后缀
        resolver.setSuffix(".jsp");
        // 可以在JSP页面中通过${}访问beans
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    // 配置springMVC处理上传文件的信息
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setMaxUploadSize(10485760000L);
        resolver.setMaxInMemorySize(40960);
        return resolver;
    }

    // 配置静态文件处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
