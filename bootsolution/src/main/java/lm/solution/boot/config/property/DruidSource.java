package lm.solution.boot.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties(prefix = "spring.druid")
@PropertySource("classpath:application.properties")
public class DruidSource {



}
