package com.thread.test3;

/**
 * Created by Michael on 3/31/17.
 */
public class MyObject {
    synchronized public void methodB() {
        System.out.println(Thread.currentThread().getName() + ": method B starts");
        System.out.println(Thread.currentThread().getName() + ": method B stops");
    }
}