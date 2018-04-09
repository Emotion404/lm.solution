package lm.solution.boot.controller;

import lm.solution.boot.config.property.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    @ResponseBody
    public String index() {

        return "author name is "+authorSettings.getName()+" and author age is "+authorSettings.getAge();
        //return "book name is:" + bookName + " and author is:" + bookAuthor;
        //return "Hello Spring Boot";

    }

}


