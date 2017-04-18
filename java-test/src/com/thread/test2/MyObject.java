package com.thread.test2;

/**
 * Created by Michael on 3/31/17.
 */
public class MyObject {
    public synchronized void methodA() {
        System.out.println("method A starts");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method A stops");
    }

    public synchronized void methodB() {
        System.out.println("method B starts");
        System.out.println("method B stops");
    }

    public void methodC() {
        System.out.println("method C starts");
        System.out.println("method C stops");
    }
}
