package lm.solution.console.spring.spring.annotationgroup;

import org.springframework.stereotype.Service;

@Service
public class BeanService {

    public void outputResult(){

        System.out.println("从组合注解配置中获得 bean ");

    }

}
