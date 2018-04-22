package lm.solution.console.spring.spring.beanprepost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

//    @Test
    public void test(){

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(PrePostConfig.class);
        BeanWayService beanWayService=context.getBean(BeanWayService.class);
        JSR250WayService jsr250WayService=context.getBean(JSR250WayService.class);
        context.close();

    }

}
