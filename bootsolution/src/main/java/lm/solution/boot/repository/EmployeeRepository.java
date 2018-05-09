package lm.solution.boot.repository;

import lm.solution.boot.entity.springdatajpa.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository
    extends JpaRepository<Employee,String> {
}
