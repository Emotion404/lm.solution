package lm.solution.console.spring.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class MethodService {

    public void add(){

        System.out.println("被拦截的方法规则式方法！");

    }

}
