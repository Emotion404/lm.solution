package lm.solution.pojo.model.console.generic;

import java.time.LocalDate;

public class Employee {

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private LocalDate localDate;

    public Employee(){}
    public Employee(String name,Integer yyyy,Integer mm,Integer dd){
        this.name=name;
        this.localDate=LocalDate.of(yyyy,mm,dd);
    }



}
