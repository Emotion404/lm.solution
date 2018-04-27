package lm.solution.boot.springdatajpa.entity;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;

// @Entity 代表一个实体类
@Entity()
// @Table(name=”employee”)用来对应MySQL中的employee数据库
@Table(appliesTo = "employee")
public class Employee {

    private static final long serialVersionUID=1L;

    // @Id 主键
    @Id
    // @Column(name=”id”)表明一个id属性
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private int age;

}
