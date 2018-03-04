package lm.solution.dto.properties;

import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties
public class TestInfoSettings {

    private String name;
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }

    private String age;
    public String getAge(){
        return this.age;
    }
    public void setAge(String age){
        this.age=age;
    }

}
