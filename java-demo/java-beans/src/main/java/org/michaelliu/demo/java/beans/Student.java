package org.michaelliu.demo.java.beans;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by Michael on 7/4/16.
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 3756302160365894878L;

    private Integer id;

    private String name;

    private Integer age;

    private Integer gender;

    private String department;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, Integer gender, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("age", age)
                .append("gender", gender)
                .append("department", department)
                .toString();
    }

}
