package lm.solution.boot.service.springdata.cache.concurrentmap;

import lm.solution.boot.entity.springdatajpa.Person;

import java.util.List;

public interface CacheConcurrentMapService {

    public Person save(Person person);

    public void remove(Long id);

    public Person findOne(Person person);

    public List<Person> allData();

}
