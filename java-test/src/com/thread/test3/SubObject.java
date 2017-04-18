package com.thread.test3;

/**
 * Created by Michael on 3/31/17.
 */
public class SubObject extends MyObject {
    synchronized public void methodA() {
        System.out.println(Thread.currentThread().getName() + ": method A starts");
        super.methodB();
        System.out.println(Thread.currentThread().getName() + ": method A stops");
    }
}
