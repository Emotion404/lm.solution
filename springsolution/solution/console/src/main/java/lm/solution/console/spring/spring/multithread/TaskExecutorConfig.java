package lm.solution.console.spring.spring.multithread;


import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;


/**
 * 利用 @EnableAsync 注解开启异步任务支持
 * */
@Configuration
@ComponentScan("lm.solution.console.spring.spring.multithread")
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer {

    /**
     * 实现 AsyncConfigurer 接口，
     * 并重写 getAsyncExecutor 方法，
     * 返回一个 ThreadPoolTaskExecutor ,
     * 这样就获得一个基于线程池的 TaskExecutor
     * */
    @Override
    public Executor getAsyncExecutor() {

        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(8);
        executor.setQueueCapacity(1000);
        executor.initialize();

        return executor;

    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

}
