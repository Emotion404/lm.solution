package lm.solution.boot.springdatajpa.repository;

import lm.solution.boot.springdatajpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

// spring data rest
// spring data jpa transaction
public interface PersonRepository extends JpaRepository<Person,Long> {

    Person findByNameStartsWith(String name);

}
