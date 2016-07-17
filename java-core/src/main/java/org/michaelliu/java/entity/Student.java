package org.michaelliu.java.entity;

import java.io.Serializable;

/**
 * Created by Michael on 7/4/16.
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 3756302160365894878L;

    private Integer id;

    private String name;

    private Integer age;

    private String department;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }

}
