package lm.solution.boot.springdatajpa.repository;

import lm.solution.boot.springdatajpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

    Person findByNameStartsWith(String name);

}
