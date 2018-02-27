package lm.solution.web.config;

import lm.solution.web.config.configs.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    // root配置类初始化
    // 指定 Root WebApplicationContext 类，这个类必须@Configuration来注解，从而代替XML配置文件
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //return new Class<?>[]{RootConfig.class};
        return new Class[0];
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
}

