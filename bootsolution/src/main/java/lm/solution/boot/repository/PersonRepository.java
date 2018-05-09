package lm.solution.boot.repository;

import lm.solution.boot.entity.springdatajpa.Person;
import org.springframework.data.jpa.repository.JpaRepository;

// spring data rest
// spring data jpa transaction
// spring data cache
public interface PersonRepository extends JpaRepository<Person,Long> {

    Person findByNameStartsWith(String name);

}
