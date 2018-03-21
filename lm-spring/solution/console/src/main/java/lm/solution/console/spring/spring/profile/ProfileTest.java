package lm.solution.console.spring.spring.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfileTest {

//    @Test
    public void test() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // dev
        context.getEnvironment().setActiveProfiles("dev");
        context.register(ProfileConfig.class);
        context.refresh();

        DemoBean dev=context.getBean(DemoBean.class);
        System.out.println(dev.getContent());

        context.close();

        // --------------------------------------------------------------------------------------

        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext();

        // prod
        context2.getEnvironment().setActiveProfiles("prod");
        context2.register(ProfileConfig.class);
        context2.refresh();

        DemoBean prod=context2.getBean(DemoBean.class);
        System.out.println(prod.getContent());

        context2.close();

    }

}
