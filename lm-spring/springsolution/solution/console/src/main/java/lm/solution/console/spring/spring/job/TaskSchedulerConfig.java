package lm.solution.console.spring.spring.job;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 通过 @EnableScheduling 注解开启对计划任务的支持
 * */
@Configuration
@ComponentScan("lm.solution.console.spring.spring.job")
@EnableScheduling
public class TaskSchedulerConfig {
}
