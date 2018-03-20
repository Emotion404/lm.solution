package lm.solution.console.spring.job;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskSchedulerTest {

//    @Test
    public void test(){
    /**
     * 宿主在 console 中执行 ，注意要用 main 方法 ，否则会退出
     * */
    //public static void main(String[] args){

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);

    }

}
