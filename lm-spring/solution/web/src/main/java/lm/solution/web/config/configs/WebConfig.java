package lm.solution.web.config.configs;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lm.solution.common.web.messageconverter.CustomMessageConverter;
import lm.solution.web.config.beans.TimerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.ArrayList;
import java.util.List;

@Configuration
/**
 * @EnableWebMvc 注解会开启一些默认配置，如：ViewResolver MessageConverter 等,
 * 若无此注解，重写 WebMvcConfigurerAdapter 方法无效
 * */
@EnableWebMvc
@ComponentScan(value = {
        "lm.solution.web",
        "lm.solution.service.mysql"
})
/**
 * 继承 WebMvcConfigurerAdapter 类，重写其方法可对 spring mvc 进行配置
 * */
public class WebConfig extends WebMvcConfigurerAdapter {

    // 重写 addViewControllers 简化页面快捷转向，这样就可以不用配置 Controller 了
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("index");
        registry.addViewController("/error").setViewName("error/error");
        registry.addViewController("/excel").setViewName("excel/excel");
        registry.addViewController("/upload").setViewName("fileupload/upload");
        registry.addViewController("/ImageValidateCodeLogin").setViewName("login/imageValidateCodeLogin");
        registry.addViewController("/restfulapi").setViewName("restful/user");
        registry.addViewController("/jaxwsri").setViewName("jaxwsri/wsri");
        registry.addViewController("/redis").setViewName("redis/jedis");
        registry.addViewController("/mybatisPage").setViewName("db/mybatis");
        registry.addViewController("/messageconverter").setViewName("");

    }

    // 配置JSP视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        /**
         * views 在 /resources/ 下
         * */
        // 前缀
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        // 后缀
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setContentType("text/html");
        // 可以在JSP页面中通过${}访问beans
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
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
    public void addResourceHandlers(ResourceHandlerRegistry registry){

        /**
         * addResourceHandler 指的是对外暴露的访问路径
         * addResourceLocations 指的是文件放置的目录
         * */
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/assets/");

    }

    // 重写 configurePathMatch ，改变路径参数匹配
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

        /**
         * Spring mvc 默认 如果路径参数后面带点，如 “/mm/nn/xx.yy” 后面的yy值将被忽略
         * 加入下面的配置，就不会忽略“.”后面的参数了
         * */
        configurer.setUseSuffixPatternMatch(false);

    }

//
//    // 负责读取二进制格式的数据和写出二进制格式的数据；
//    @Bean
//    public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
//
//        return new ByteArrayHttpMessageConverter();
//
//    }
//
//    // 负责读取字符串格式的数据和写出字符串格式的数据；
//    @Bean
//    public StringHttpMessageConverter stringHttpMessageConverter() {
//
//        StringHttpMessageConverter messageConverter = new StringHttpMessageConverter();
//        messageConverter.setDefaultCharset(Charset.forName("UTF-8"));
//        return messageConverter;
//
//    }
//
//    // 负责读取资源文件和写出资源文件数据；
//    @Bean
//    public ResourceHttpMessageConverter resourceHttpMessageConverter() {
//
//        return new ResourceHttpMessageConverter();
//
//    }
//
//    /**
//     * 负责读取form提交的数据
//     * 能读取的数据格式为 application/x-www-form-urlencoded，
//     * 不能读取multipart/form-data格式数据；
//     * 负责写入application/x-www-from-urlencoded和multipart/form-data格式的数据；
//     */
//    @Bean
//    public FormHttpMessageConverter formHttpMessageConverter() {
//
//        return new FormHttpMessageConverter();
//
//    }
//
//    // 负责读取和写入json格式的数据；
//    /**
//     * 配置 fastjson 中实现 HttpMessageConverter 接口的转换器
//     * FastJsonHttpMessageConverter 是 fastjson 中实现了 HttpMessageConverter 接口的类
//     */
//    @Bean(name = "fastJsonHttpMessageConverter")
//    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
//        //
//        String txtHtml = "text/html;charset=UTF-8";
//        String txtJson = "text/json;charset=UTF-8";
//        String appJson = "application/json;charset=UTF-8";
//
//        // 这里顺序不能反，一定先写 text/html,不然 IE 下会出现下载提示
//        List<MediaType> mediaTypes = new ArrayList<>();
//        mediaTypes.add(MediaType.parseMediaType(txtHtml));
//        mediaTypes.add(MediaType.parseMediaType(txtJson));
//        mediaTypes.add(MediaType.parseMediaType(appJson));
//
//        // 加入支持的媒体类型，返回 contentType
//        FastJsonHttpMessageConverter fastjson = new FastJsonHttpMessageConverter();
//        fastjson.setSupportedMediaTypes(mediaTypes);
//        return fastjson;
//
//    }
//
//    // 负责读取和写入 xml 中javax.xml.transform.Source定义的数据；
//    @Bean
//    public SourceHttpMessageConverter sourceHttpMessageConverter() {
//
//        return new SourceHttpMessageConverter();
//
//    }
//
//    // 负责读取和写入xml 标签格式的数据；
//    @Bean
//    public Jaxb2RootElementHttpMessageConverter jaxb2RootElementHttpMessageConverter() {
//
//        return new Jaxb2RootElementHttpMessageConverter();
//
//    }
//
//    // 注册消息转换器
//    /**
//     * 重写 configureMessageConverters 会覆盖掉 spring mvc 默认注册的多个 HttpMessageConverter
//     * 所以 推荐使用 extendMessageConverter
//     * */
//    /**
//     * Error:
//     * 400：（错误请求） 服务器不理解请求的语法。
//     * 415：（不支持的媒体类型） 请求的格式不受请求页面的支持。
//     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//
//        converters.add(this.byteArrayHttpMessageConverter());
//        converters.add(this.stringHttpMessageConverter());
//        converters.add(this.resourceHttpMessageConverter());
//        converters.add(this.formHttpMessageConverter());
//        converters.add(this.fastJsonHttpMessageConverter());
//        converters.add(this.sourceHttpMessageConverter());
//        converters.add(this.jaxb2RootElementHttpMessageConverter());
//
//    }

    // 自定义 HttpMessageConverter
    @Bean
    public CustomMessageConverter customMessageConverter(){

        return new CustomMessageConverter();

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

    /**
     * 重写 extendMessageConverters 方法，仅添加自定义 HttpMessageConverter
     * 不覆盖默认注册的 HttpMessageConverter
     * */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(customMessageConverter());
        converters.add(fastJsonHttpMessageConverter());

    }

    // 拦截器 bean
    @Bean
    public TimerInterceptor timerInterceptor(){

        return new TimerInterceptor();

    }

    // 重写 addInterceptors 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(timerInterceptor());

    }

}
