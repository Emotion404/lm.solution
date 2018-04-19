package lm.solution.web.controller.customconverter;

import lm.solution.pojo.entity.web.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomConverterController {

    /**
     * 指定的返回媒体类型，为我们自定义的媒体类型 application/x-wisely
     * */
    @RequestMapping(
            value = "/convertpage/customconvert",
            produces ={"application/x-wisely"})
    @ResponseBody
    public DemoObj convert(@RequestBody DemoObj demoObj){

        return demoObj;

    }


}
