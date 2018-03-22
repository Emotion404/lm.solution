package lm.solution.web.config;

import lm.solution.web.config.configs.RootConfig;
import lm.solution.web.config.configs.WebConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * WebInitializer继承关系链：
 * WebInitializer -->
 * AbstractAnnotationConfigDispatcherServletInitializer  -->
 * AbstractDispatcherServletInitializer  -->
 * AbstractContextLoaderInitializer  -->
 * WebApplicationInitializer
 * 实现 WebApplicationInitializer 接口，就等同于 web.xml 配置
 * */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(
            ServletContext servletContext
    ) throws ServletException{

        super.onStartup(servletContext);

        // spring 字符过滤
        FilterRegistration.Dynamic encodingFilter=servletContext.addFilter("encoding-filter",CharacterEncodingFilter.class);
        encodingFilter.setInitParameter("encoding","UTF-8");
        encodingFilter.setInitParameter("forceEncoding","true");
        encodingFilter.setAsyncSupported(true);
        encodingFilter.addMappingForUrlPatterns(null,true,"/*");

    }

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

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration){

        // 让404作为异常抛出 不使用tomcat默认的
        registration.setInitParameter("throwExceptionIfNoHandlerFound","true");

    }
}

