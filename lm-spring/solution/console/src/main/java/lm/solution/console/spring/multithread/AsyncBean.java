package lm.solution.console.spring.multithread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncBean {

    /**
     * 通过 @Async 注解表明该方法是异步方法，
     * 如果注解在类级别，则表明该类所有方法都是异步方法，
     * 这里的方法自动被注入使用 ThreadPoolTaskExecutor 做为 TaskExecutor
     * */
    @Async
    public void executeAsyncTask(Integer i){

        System.out.println("异步执行："+i);

    }

    @Async
    public void executeAsyncTaskPlus(Integer i){

        System.out.println("异步执行+1:"+(i+1));

    }

}
