package lm.solution.console.spring.spring.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public DemoBean devDemoBean(){

        return  new DemoBean("from dev profile context");

    }

    @Bean
    @Profile("prod")
    public DemoBean prodDemoBean(){

        return new DemoBean("from prod profile context");

    }

}
