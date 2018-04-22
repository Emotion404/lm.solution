package lm.solution.web.controller.mocktest;

import lm.solution.service.webtest.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/test/restMockTest",produces = "text/plain;charset=UTF-8")
    public String testRest(){

        return demoService.springMvcTest();

    }

}
