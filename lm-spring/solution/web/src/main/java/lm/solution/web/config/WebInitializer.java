package lm.solution.web.config;

import lm.solution.web.config.configs.RootConfig;
import lm.solution.web.config.configs.WebConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // root配置类初始化
    // 指定 Root WebApplicationContext 类，这个类必须@Configuration来注解，从而代替XML配置文件
    @Override
    protected Class<?>[] getRootConfigClasses() {

        return new Class<?>[]{RootConfig.class};

    }

    // web配置类初始化
    // 指定 Servlet WebApplicationContext 类，这个类必须@Configuration来注解，从而代替XML配置文件
    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class<?>[]{WebConfig.class};

    }

    // 映射根路径初始化
    // 指定 Servlet mappings
    @Override
    protected String[] getServletMappings() {

        return new String[]{"/"};

    }

    // 配置Spring字符编码过滤器
    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;

    }

    @Override
    protected Filter[] getServletFilters(){

        return new Filter[] { characterEncodingFilter() };

    }

}

