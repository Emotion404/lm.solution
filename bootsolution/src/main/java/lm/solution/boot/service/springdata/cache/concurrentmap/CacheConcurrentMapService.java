package lm.solution.boot.service.springdata.cache.concurrentmap;

import lm.solution.boot.entity.springdatajpa.Person;

public interface CacheConcurrentMapService {

    public Person save(Person person);

    public void remove(Long id);

    public Person findOne(Person person);

}
