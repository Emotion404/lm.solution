package lm.solution.console.spring.profile;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebInit implements WebApplicationInitializer {

    /**
     * 通过设定 Environment 的 ActiveProfiles 来设定当前 context 需要使用的配置环境，
     * 在开发中使用 @Profile 注解类或者方法，达到在不同情况下选择实例化不同的 Bean ,
     * 通过设定 jvm 的 spring.profiles.active 参数来设置配置环境，
     * Web 项目设置在 Servlet 的 context parameter 中。
     * */
    @Override
    public void onStartup(ServletContext container) throws ServletException {

        container.setInitParameter("spring.profiles.default","dev");

    }

}
