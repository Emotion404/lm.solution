package lm.solution.boot.controller.springdata;

import lm.solution.boot.service.springdata.jpa.transaction.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lm.solution.boot.entity.springdatajpa.Person;
import java.util.List;

@Controller
@RequestMapping("/SpringDataJpaTransaction")
public class TransactionPersonController {

    @RequestMapping("/transaction")
    public String transaction(){

        return "springdata/transaction";

    }

    @Autowired
    private PersonService personService;

    @RequestMapping(
            value = "/withRollback",
            method = RequestMethod.POST,
            consumes = {"application/json"}
    )
    @ResponseBody
    public Person rollback(@RequestBody Person person){

        return personService.savePersonWithRollback(person);

    }

    @RequestMapping(value = "/withoutRollback",method = RequestMethod.POST)
    @ResponseBody
    public Person noRollback(@RequestBody Person person){

        return personService.savePersonWithoutRollback(person);

    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Person> getAll(){

        return personService.findAll();

    }

}
