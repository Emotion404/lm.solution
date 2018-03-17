package lm.solution.console.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {

//    @Test
    public void testAOP(){

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Config.class);

        AnnotationService annotationService=context.getBean(AnnotationService.class);
        annotationService.add();

        MethodService methodService=context.getBean(MethodService.class);
        methodService.add();

        context.close();

    }

}
