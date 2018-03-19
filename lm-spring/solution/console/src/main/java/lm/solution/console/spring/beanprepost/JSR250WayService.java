package lm.solution.console.spring.beanprepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {

    // @PostConstruct 在构造函数完成之后执行
    @PostConstruct
    public void init(){

        System.out.println("jsr250-way-init-after");

    }

    public JSR250WayService(){

        super();
        System.out.println("构造函数");

    }

    // @PreDestroy 在 bean 销毁之前执行
    @PreDestroy
    public void destroy(){

        System.out.println("jsr250-way-destroy-pre");

    }

}
