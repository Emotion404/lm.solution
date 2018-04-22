package lm.solution.console.spring.spring.springel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ElTest {

//    @Test
    public void test() {

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ElConfig.class);

        ElConfig resourceService=context.getBean(ElConfig.class);

        resourceService.outputResource();

        context.close();

    }

}
