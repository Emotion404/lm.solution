package lm.solution.web.controller.handleradvice;

import lm.solution.pojo.entity.web.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdviceController {

    @RequestMapping("/advice/globalHandlerAdvice")
    public String handlerAdvice(
            @ModelAttribute("msg") String msg,
            DemoObj obj ){

        throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute:"+msg);

    }

}
