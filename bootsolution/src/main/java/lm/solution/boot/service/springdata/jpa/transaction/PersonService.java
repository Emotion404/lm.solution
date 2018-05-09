package lm.solution.boot.service.springdata.jpa.transaction;

import lm.solution.boot.entity.springdatajpa.Person;

import java.util.List;

public interface PersonService {

    public Person savePersonWithRollback(Person person);
    public Person savePersonWithoutRollback(Person person);
    public List<Person> findAll();

}
