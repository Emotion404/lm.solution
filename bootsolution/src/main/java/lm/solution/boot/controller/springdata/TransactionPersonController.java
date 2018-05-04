package lm.solution.boot.controller.springdata;

import lm.solution.boot.service.springdata.jpa.transaction.PersonService;
import lm.solution.boot.springdatajpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/SpringDataJpaTransaction")
public class TransactionPersonController {

    @RequestMapping("/transaction")
    public String transaction(){

        return "springdata/transaction";

    }

    @Autowired
    private PersonService personService;

    @RequestMapping("/withRollback")
    @ResponseBody
    public Person rollback(Person person){

        return personService.savePersonWithRollback(person);

    }

    @RequestMapping("/withoutRollback")
    @ResponseBody
    public Person noRollback(Person person){

        return personService.savePersonWithoutRollback(person);

    }

}
