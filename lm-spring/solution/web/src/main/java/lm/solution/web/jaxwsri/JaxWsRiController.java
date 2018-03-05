package lm.solution.web.jaxwsri;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lm.solution.web.config.jaxwsclient.SquareRootServer;
import lm.solution.web.config.jaxwsclient.SquareRootServerImplService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JaxWsRiController {

    private SquareRootServer service;
    {
        service=new SquareRootServerImplService().getSquareRootServerImplPort();
    }

    @RequestMapping(
            value = "/jaxws/getTime",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getTime() {

        try {
            String time = service.getTimeRI();

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(time);
        } catch (JsonProcessingException e) {
            return "{}";
        }

    }

    @RequestMapping(
            value = "/jaxws/getSquare",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getSquare(@RequestParam("s") double num) {

        try {
            double square = service.getSquareRootRI(num);

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(square);
        } catch (JsonProcessingException e) {
            return "{}";
        }

    }

}
