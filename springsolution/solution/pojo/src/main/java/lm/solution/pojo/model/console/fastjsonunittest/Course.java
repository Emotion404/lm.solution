package lm.solution.pojo.model.console.fastjsonunittest;

public class Course {

    public Course(){

    }

    public Course(String courseName,Integer code){

        this.courseName=courseName;
        this.code=code;

    }

    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
