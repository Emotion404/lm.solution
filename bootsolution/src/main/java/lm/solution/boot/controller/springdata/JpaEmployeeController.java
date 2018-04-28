package lm.solution.boot.controller.springdata;

import lm.solution.boot.springdatajpa.repository.EmployeeRepository;
import lm.solution.boot.springdatajpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jpaEmployee")
public class JpaEmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/queryAll")
    public List<Employee> queryAll() {
        List<Employee> list = new ArrayList<>();
        list=employeeRepository.findAll();
        return list;
    }

}
