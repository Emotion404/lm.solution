package lm.solution.web.config.beans;

import lm.solution.web.config.jaxwsclient.SquareRootServer;
import lm.solution.web.config.jaxwsclient.SquareRootServerImplService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class JaxWsRiBean {

    @Lazy(true)
    @Bean(name = "squareRootServerJaxws")
    public SquareRootServer squareRootServer(){

        SquareRootServer jaxws= new SquareRootServerImplService().getSquareRootServerImplPort();
        return jaxws;
    }

}
