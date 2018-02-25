package lm.solution.web.config;

import lm.solution.web.config.configs.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//public class WebInitializer
//        extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//    //
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
////        return new Class<?>[]{ContextConfig.class};
//        return new Class[0];
//    }
//
//    // Spring mvc 容器
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class<?>[]{WebConfig.class};
//    }
//
//    // DispatcherServlet映射,从"/"开始
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] {"/"};
//    }
//
//}


public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        context.setConfigLocation("classpath:spring-mvc.xml");
        context.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",
                new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}


