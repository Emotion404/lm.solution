package lm.solution.boot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * SpringBoot的默认处理是：
     * 加载static | public | resources下面的资源，当然也可以自己定义目录
     * 如： /static/bootstrap/css/bootstrap.css  -->  th:href="@{/bootstrap/css/bootstrap.css}"
     * 自定义静态目录如下代码【myStatic】，此时，系统默认的访问地址static | public | resources 那些就不可用了：
     * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

        //注：ResourceUtils.CLASSPATH_URL_PREFIX就是"classpath:",如果不加这个，就会提示找不到资源
        registry.addResourceHandler("/myStatic/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/myStatic/");

        registry.addResourceHandler("/templates/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");

        super.addResourceHandlers(registry);

    }

}
