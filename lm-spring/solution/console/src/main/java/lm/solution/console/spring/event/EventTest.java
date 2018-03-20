package lm.solution.console.spring.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventTest {

//    @Test
    public void test(){

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(EventConfig.class);

        DemoPublisher publisher=context.getBean(DemoPublisher.class);
        publisher.publish("lm msg test");

        context.close();

    }

}
