package lm.solution.console.spring.spring.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DiTest {

//    @Test
    public void test(){

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DiConfig.class);
        UseFunctionService useFunctionService=context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("world"));
        context.close();

    }

}
