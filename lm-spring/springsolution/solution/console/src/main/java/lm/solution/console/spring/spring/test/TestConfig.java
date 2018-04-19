package lm.solution.console.spring.spring.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestConfig {

    @Bean
    @Profile("dev")
    public TestBean devBean(){

        return new TestBean("dev");

    }

    @Bean
    @Profile("prod")
    public  TestBean prodBean(){

        return new TestBean("prod");

    }

}
