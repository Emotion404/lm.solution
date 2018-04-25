package lm.solution.console.spring.spring.conditional;

import lm.solution.pojo.model.console.spring.spring.ListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConifg {

    /**
     * 通过 @Conditional 注解，
     * 符合 windows 条件则实例化 WindowsListService ，
     * 符合 linux 条件则实例化 LinuxListService
     * */
    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsListService(){

        return new WindowsListService();

    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxListService(){

        return new LinuxListService();

    }

}
