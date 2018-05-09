package lm.solution.boot.controller.springdata;


import lm.solution.boot.entity.springdatajpa.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import lm.solution.boot.repository.EmployeeRepository;

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
