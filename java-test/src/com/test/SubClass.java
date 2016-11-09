package com.test;

public class SubClass extends SuperClass {

    static {
        System.out.println("static block in SubClass");
    }

    public SubClass() {
        System.out.println("constructor in SubClass");
    }

    public static void main(String[] args) {
        SuperClass obj = new SubClass();
    }
}
