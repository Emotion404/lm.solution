package lm.solution.boot.springdatajpa.dao;

import lm.solution.boot.springdatajpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository
    extends JpaRepository<Employee,String> {
}
