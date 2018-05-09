package lm.solution.boot.controller.action;

import lm.solution.boot.entity.springdatajpa.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActionController {

    // spring mvc 自动将 Person 转为 json
    @RequestMapping(
            value = "/action/search",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person search(String personName){

        return new Person(personName,32,"HeFei");

    }

}

