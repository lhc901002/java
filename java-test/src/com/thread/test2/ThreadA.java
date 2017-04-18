package com.thread.test2;

/**
 * Created by Michael on 3/31/17.
 */
public class ThreadA implements Runnable {

    private MyObject myObject;

    public ThreadA(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        myObject.methodA();
    }
}
