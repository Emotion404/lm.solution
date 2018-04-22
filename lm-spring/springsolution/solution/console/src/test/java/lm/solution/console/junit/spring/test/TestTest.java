package lm.solution.console.junit.spring.test;

import lm.solution.console.spring.spring.test.TestBean;
import lm.solution.console.spring.spring.test.TestConfig;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

/**
 * spring 继承测试
 */
/**
 * SpringJUnit4ClassRunner 在 JUnit 环境下提供 Spring TestContext Framework 的功能
 * */
//@RunWith(SpringJUnit4ClassRunner.class)
/**
 * @ContextConfiguration 用来加载配置 ApplicationContext ,其中 classes 属性用来加载配置类
 * */
@ContextConfiguration(classes = {TestConfig.class})
/**
 * @ActiveProfiles 用来声明活动的 profile
 * */
@ActiveProfiles("dev")
public class TestTest {

    @Autowired
    private TestBean testBean;

//    @Test
    public void test(){

        String expected="dev";
        String actual=testBean.getContent();
        Assert.assertEquals(expected,actual);

    }

}
