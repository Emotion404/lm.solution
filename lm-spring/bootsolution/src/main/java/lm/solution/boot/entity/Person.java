package lm.solution.boot.entity;

public class Person {

    private String name;
    private Integer age;
//private

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public Person(){

        super();

    }

    public Person(String name,Integer age){

        super();
        this.name=name;
        this.age=age;

    }

}
