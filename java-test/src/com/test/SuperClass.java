package com.test;

public class SuperClass {

    static {
        System.out.println("static block in SuperClass");
    }

    public SuperClass() {
        System.out.println("constructor in SuperClass");
    }
}
