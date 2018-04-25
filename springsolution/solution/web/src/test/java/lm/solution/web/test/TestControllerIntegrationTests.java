package lm.solution.web.test;

import lm.solution.service.webtest.DemoService;
import lm.solution.web.config.configs.RootConfig;
import lm.solution.web.config.configs.WebConfig;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
/**
 * @WebAppConfiguration 注解在类上，
 * 用来声明加载的 ApplicationContext 是一个 WebApplicationContext ,
 * 它的属性指定的是 web 资源的位置，默认是 src/main/webapp
 * */
@WebAppConfiguration("src/main/resources")
public class TestControllerIntegrationTests {

    /**
     * MockMvc 模拟MVC对象，通过 MockMvcBuilders.webAppContextSetup(this.appContext).build(); 初始化
     * */
    private MockMvc mockMvc;

    @Autowired
    private DemoService demoService;

    @Autowired
    private WebApplicationContext appContext;

    // 模拟 session
    @Autowired
    private MockHttpSession session;

    // 模拟 http request
    @Autowired
    private MockHttpServletRequest request;

    /**
     * @Before 在测试开始前进行的初始化工作
     * */
    @Before
    public void setup(){

        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.appContext).build();

    }

//    @Test
    public void testNormalController()
        throws Exception{

        mockMvc.perform(get("/test/normal"))   // 模拟 get 请求
                .andExpect(status().isOk())  // 预期返回状态 200
                .andExpect(view().name("mocktest/page"))  // 预期返回的view名称
                .andExpect(forwardedUrl("/WEB-INF/classes/views/mocktest/page.jsp"))  // 预期页面转向的真实路径
                .andExpect(model().attribute("msg",demoService.springMvcTest()));  // 预期model中的值

    }

//    @Test
    public void testRestController()
        throws Exception{

        mockMvc.perform(get("/test/restMockTest"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))  // 预期返回值的媒体类型
                .andExpect(content().string(demoService.springMvcTest()));  // 预期返回值的内容

    }

}
