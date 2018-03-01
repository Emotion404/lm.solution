//package lm.solution.web.config.beans;
//
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class FastjsonBean {
//
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
//    /**
//     * 启动Spring MVC的注解功能，完成请求和注解POJO的映射，
//     * 配置一个基于注解的定制的WebBindingInitializer，
//     * 解决日期转换问题，方法级别的处理器映射
//     */
//    @Bean
//    public AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter(FastJsonHttpMessageConverter fastjson) {
//
//        //
//        AnnotationMethodHandlerAdapter adapter = new AnnotationMethodHandlerAdapter();
//        adapter.setCacheSeconds(0);
//        adapter.setMessageConverters(new HttpMessageConverter<?>[]{
//                fastjson
//        });
//        return adapter;
//
//    }
//
//}
