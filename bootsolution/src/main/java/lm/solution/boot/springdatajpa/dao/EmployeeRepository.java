package lm.solution.boot.springdatajpa.dao;

import lm.solution.boot.springdatajpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
    extends JpaRepository<Employee,String> {
}
