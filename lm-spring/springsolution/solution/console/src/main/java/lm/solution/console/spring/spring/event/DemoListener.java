package lm.solution.console.spring.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// 实现 ApplicationListener 接口并指定监听的事件类型
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    // onApplicationEvent 方法对消息进行接受处理
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg=event.getMsg();
        System.out.println("bean DemoListener 接收到了 bean DemoPublisher 发布的消息："+msg);
    }

}
