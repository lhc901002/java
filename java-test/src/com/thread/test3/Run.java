package com.thread.test3;

/**
 * Created by Michael on 3/31/17.
 */
public class Run {
    public static void main(String[] args) {
        try {
            SubObject subObject = new SubObject();
            MyObject myObject = subObject;
            new Thread(new ThreadA(subObject), "Thread A").start();
            Thread.sleep(500);
            new Thread(new ThreadB(myObject), "Thread B").start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
