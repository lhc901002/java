package com.reflection;

public class User {

    private Integer id;

    private String name;

    public User() {}

    private User(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    private void privatePrint(Integer id, String name) {
        System.out.println("id: " + id + ", name: " + name);
    }

    public void print() {
        System.out.println("id: " + id + ", name: " + name);
    }

    public void print(Integer id, String name) {
        System.out.println("id: " + id + ", name: " + name);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
