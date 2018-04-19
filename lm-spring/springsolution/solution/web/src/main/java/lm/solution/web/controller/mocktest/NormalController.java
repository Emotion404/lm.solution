package lm.solution.web.controller.mocktest;

import lm.solution.service.webtest.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NormalController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/test/normal")
    public String testPage(Model model){

        model.addAttribute("msg",demoService.springMvcTest());
        return "mocktest/page";

    }

}
