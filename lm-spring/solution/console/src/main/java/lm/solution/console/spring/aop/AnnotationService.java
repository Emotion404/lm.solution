package lm.solution.console.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class AnnotationService {

    @Action(name = "注解式拦截的add操作")
    public void add(){

        System.out.println("被拦截的注解方法！");

    }

}
