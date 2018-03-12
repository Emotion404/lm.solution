package lm.solution.web.config.configs;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.*;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
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
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer
    ) {

        configurer.enable();

    }

    // 负责读取二进制格式的数据和写出二进制格式的数据；
    @Bean
    public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter(){

        return  new ByteArrayHttpMessageConverter();

    }

    // 负责读取字符串格式的数据和写出字符串格式的数据；
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter(){

        StringHttpMessageConverter messageConverter=new StringHttpMessageConverter();
        messageConverter.setDefaultCharset(Charset.forName("UTF-8"));
        return  messageConverter;

    }

    // 负责读取资源文件和写出资源文件数据；
    @Bean
    public ResourceHttpMessageConverter resourceHttpMessageConverter(){

        return new ResourceHttpMessageConverter();

    }

    /**
     * 负责读取form提交的数据
     * 能读取的数据格式为 application/x-www-form-urlencoded，
     * 不能读取multipart/form-data格式数据；
     * 负责写入application/x-www-from-urlencoded和multipart/form-data格式的数据；
     * */
    @Bean
    public FormHttpMessageConverter formHttpMessageConverter(){

        return new FormHttpMessageConverter();

    }

    // 负责读取和写入json格式的数据；
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

    // 负责读取和写入 xml 中javax.xml.transform.Source定义的数据；
    @Bean
    public SourceHttpMessageConverter sourceHttpMessageConverter(){

        return new SourceHttpMessageConverter();

    }

    // 负责读取和写入xml 标签格式的数据；
    @Bean
    public Jaxb2RootElementHttpMessageConverter jaxb2RootElementHttpMessageConverter(){

        return new Jaxb2RootElementHttpMessageConverter();

    }

    // 注册消息转换器
    /**
     * Error:
     * 400：（错误请求） 服务器不理解请求的语法。
     * 415：（不支持的媒体类型） 请求的格式不受请求页面的支持。
     * */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){

        converters.add(this.byteArrayHttpMessageConverter());
        converters.add(this.stringHttpMessageConverter());
        converters.add(this.resourceHttpMessageConverter());
        converters.add(this.formHttpMessageConverter());
        converters.add(this.fastJsonHttpMessageConverter());
        converters.add(this.sourceHttpMessageConverter());
        converters.add(this.jaxb2RootElementHttpMessageConverter());
        //converters.add(this.atomFeedHttpMessageConverter());
        //converters.add(this.rssChannelHttpMessageConverter());

    }

}
