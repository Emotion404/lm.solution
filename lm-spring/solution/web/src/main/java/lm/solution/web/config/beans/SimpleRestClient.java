package lm.solution.web.config.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @component  把普通pojo实例化到spring容器中，相当于配置文件中的  bean id="" class=""
 * @Component  泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
 *
 * @Lazy :
 * ApplicationContext实现的默认行为就是在启动时将所有singleton bean提前进行实例化
 * false -- 立即加载，表示spring启动时，立刻进行实例化
 * true -- 延迟加载，bean将不会在ApplicationContext启动时提前被实例化，而是在第一次向容器通过getBean索取bean时实例化的
 * */
@Component("simpleRestClient")
@Lazy(false)
public class SimpleRestClient {

    /**
     * 基于jdk的spring的RestTemplate
     * */

    private static final Logger LOGGER= LoggerFactory.getLogger(SimpleRestClient.class);

    private static RestTemplate restTemplate;
    static {
        SimpleClientHttpRequestFactory requestFactory=new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(5000);
        requestFactory.setConnectTimeout(5000);

        // 添加转换器
        List<HttpMessageConverter<?>> messageConverters=new ArrayList<>();
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new MappingJackson2XmlHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());

        restTemplate=new RestTemplate(messageConverters);
        restTemplate.setRequestFactory(requestFactory);
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());

        LOGGER.info("SimpleRestClient初始化完成");
    }

    private SimpleRestClient(){

    }

    /**
     * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，
     * 并且只会被服务器调用一次，类似于Servlet的init()方法。
     * 被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行。
     *
     * 被@PreConstruct修饰的方法会在服务器卸载Servlet的时候运行，
     * 并且只会被服务器调用一次，类似于Servlet的destroy()方法。
     * 被@PreConstruct修饰的方法会在destroy()方法之后运行，在Servlet被彻底卸载之前。
     * */
    @PostConstruct
    public static RestTemplate getClient(){
        return restTemplate;
    }

}
