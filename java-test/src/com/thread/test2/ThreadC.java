package com.thread.test2;

/**
 * Created by Michael on 3/31/17.
 */
public class ThreadC implements Runnable {
    private MyObject myObject;

    public ThreadC(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        myObject.methodC();
    }
}
