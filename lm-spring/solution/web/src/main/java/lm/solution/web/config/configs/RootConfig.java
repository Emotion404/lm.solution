package lm.solution.web.config.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan(basePackages = "")
@Import({RedisConfig.class})
public class RootConfig {

}
