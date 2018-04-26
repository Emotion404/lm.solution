package lm.solution.console.spring.spring.annotationgroup;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * 组合 @Configuration @ComponentScan 元注解
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
public @interface WiselyConfiguration {

    // 覆盖 value 参数
    String[] value() default {};

}
