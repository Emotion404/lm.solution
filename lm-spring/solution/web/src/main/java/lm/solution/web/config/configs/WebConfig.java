package lm.solution.web.config.configs;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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

    // 字符串消息转换器
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter(){

        StringHttpMessageConverter messageConverter=new StringHttpMessageConverter();
        messageConverter.setDefaultCharset(Charset.forName("UTF-8"));
        return  messageConverter;

    }

    /**
     * 配置 fastjson 中实现 HttpMessageConverter 接口的转换器
     * FastJsonHttpMessageConverter 是 fastjson 中实现了 HttpMessageConverter 接口的类
     */
    @Bean(name = "fastJsonHttpMessageConverter")
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        //
        String txtHtml = "text/html;charset=UTF-8";
        String txtJson = "text/json;charset=UTF-8";
        String appJson = "application/json;charset=UTF-8";

        // 这里顺序不能反，一定先写 text/html,不然 IE 下会出现下载提示
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.parseMediaType(txtHtml));
        mediaTypes.add(MediaType.parseMediaType(txtJson));
        mediaTypes.add(MediaType.parseMediaType(appJson));

        // 加入支持的媒体类型，返回 contentType
        FastJsonHttpMessageConverter fastjson = new FastJsonHttpMessageConverter();
        fastjson.setSupportedMediaTypes(mediaTypes);
        return fastjson;

    }

    // 注册消息转换器
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){

        converters.add(this.stringHttpMessageConverter());
        converters.add(this.fastJsonHttpMessageConverter());

    }

}
