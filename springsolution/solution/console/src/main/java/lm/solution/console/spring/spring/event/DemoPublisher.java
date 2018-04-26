package lm.solution.console.spring.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {

    @Autowired
    private ApplicationContext context;

    // 使用 ApplicationContext.publishEvent 方法来发布 event
    public void publish(String msg){
        context.publishEvent(new DemoEvent(this,msg));
    }

}
