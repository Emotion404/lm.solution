package lm.solution.console.spring.beanprepost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("lm.solution.console.spring.beanprepost")
public class PrePostConfig {

    /**
     * initMethod 指定 bean 构造之后执行的方法
     * destroyMethod 指定 bean 销毁之前执行的方法
     * */
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public BeanWayService beanWayService(){

        return new BeanWayService();

    }

    @Bean
    public JSR250WayService jsr250WayService(){

        return new JSR250WayService();

    }

}
