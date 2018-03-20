package lm.solution.console.spring.multithread;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ThreadPoolTaskExecutorTest {

//    @Test
    public void test() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

        AsyncBean async = context.getBean(AsyncBean.class);

        for(int i=0;i<20;i++){

            async.executeAsyncTask(i);
            async.executeAsyncTaskPlus(i);

        }

        context.close();

    }

}
