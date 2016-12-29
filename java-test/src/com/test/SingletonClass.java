package com.test;

public class SingletonClass {

    private SingletonClass() {
        System.out.println("SingletonClass has created!");
    }

    private static final SingletonClass single = new SingletonClass();

    public static SingletonClass getInstance() {
        return single;
    }

}
