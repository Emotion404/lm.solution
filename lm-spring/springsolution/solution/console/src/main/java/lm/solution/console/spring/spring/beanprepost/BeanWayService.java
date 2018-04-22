package lm.solution.console.spring.spring.beanprepost;

public class BeanWayService {

    public void init(){

        System.out.println("@Bean-way-init-after");

    }

    public BeanWayService(){

        super();
        System.out.println("构造函数");

    }

    public void destroy(){

        System.out.println("@Bean-way-destroy-pre");

    }

}
