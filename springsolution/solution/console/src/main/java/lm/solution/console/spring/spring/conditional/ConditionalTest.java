package lm.solution.console.spring.spring.conditional;

import lm.solution.pojo.model.console.spring.spring.ListService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionalTest {

//    @Test
    public void test(){

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(ConditionConifg.class);
        context.refresh();

        ListService listService=context.getBean(ListService.class);

        System.out.println(context.getEnvironment().getProperty("os.name")
                +"系统下的列表命令为："
                +listService.showListCmd());

        context.close();

    }

}
