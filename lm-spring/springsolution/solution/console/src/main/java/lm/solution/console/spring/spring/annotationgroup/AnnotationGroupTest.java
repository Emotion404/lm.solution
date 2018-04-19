package lm.solution.console.spring.spring.annotationgroup;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationGroupTest {

//    @Test
    public void test(){

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(DemoConfig.class);
        context.refresh();

        BeanService beanService=context.getBean(BeanService.class);
        beanService.outputResult();

        context.close();

    }

}
