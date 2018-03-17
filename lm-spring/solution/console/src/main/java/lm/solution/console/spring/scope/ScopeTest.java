package lm.solution.console.spring.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeTest {

//    @Test
    public void test(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ScopeConfig.class);

        SingletonService s1=context.getBean(SingletonService.class);
        SingletonService s2=context.getBean(SingletonService.class);

        PrototypeService p1=context.getBean(PrototypeService.class);
        PrototypeService p2=context.getBean(PrototypeService.class);

        System.out.println("s1 equals s2 ? "+s1.equals(s2));
        System.out.println("p1 equals p2 ? "+p1.equals(p2));

        context.close();
    }

}
