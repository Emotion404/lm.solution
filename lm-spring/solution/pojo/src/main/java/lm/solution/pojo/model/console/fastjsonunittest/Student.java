package lm.solution.pojo.model.console.fastjsonunittest;

public class Student {

    public Student(){

    }

    public Student(String studentName,Integer studentAge){

        this.studentName=studentName;
        this.studentAge=studentAge;

    }

    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    private Integer studentAge;

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }
}
