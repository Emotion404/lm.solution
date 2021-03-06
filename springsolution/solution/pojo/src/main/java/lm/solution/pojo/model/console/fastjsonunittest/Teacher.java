package lm.solution.pojo.model.console.fastjsonunittest;

import java.util.List;

public class Teacher {

    public Teacher(){



    }

    public Teacher(String teacherName,Integer teacherAge,Course course,List<Student> students){

        this.teacherName=teacherName;
        this.teacherAge=teacherAge;
        this.course=course;
        this.students=students;

    }

    private String teacherName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    private Integer teacherAge;

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
