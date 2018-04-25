package lm.solution.console.spring.spring.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTest {

//    @Test
    public void test(){

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFunctionService useFunctionService=context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("java config"));
        context.close();

    }

}
