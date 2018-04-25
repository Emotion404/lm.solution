package lm.solution.web.config.beans;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice 组合了 @Component 所以自动会注册为 bean
 * @ControllerAdvice 声明一个控制器建言
 * */
@ControllerAdvice
public class GlobalExceptionHandlerAdvice {

    /**
     * 在此处定义全局处理
     * 通过 @ExceptionHandler 的 value 设置可过滤拦截的条件
     * 此处拦截所有的 Exception
     * */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request){

        // error 页面
        ModelAndView mv=new ModelAndView("error/error");
        mv.addObject("errorMessage",exception.getMessage());
        return mv;

    }

    /**
     * 此处使用 @ModelAttribute 注解将键值对添加到全局
     * 所有注解 @RequestMapping 的方法都可获得此键值对
     * */
    @ModelAttribute
    public void addAttributes(Model model){

        model.addAttribute("msg","额外信息");

    }

    /**
     * 通过 @InitBinder 注解定制 WebDataBinder
     * 可设置特定字段的行为
     * */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){

        // 此处忽略 参数 id
        webDataBinder.setDisallowedFields("id");

    }

}
