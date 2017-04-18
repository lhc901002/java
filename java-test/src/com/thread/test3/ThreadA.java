package com.thread.test3;

/**
 * Created by Michael on 3/31/17.
 */
public class ThreadA implements Runnable {

    private SubObject subObject;

    public ThreadA(SubObject subObject) {
        this.subObject = subObject;
    }

    @Override
    public void run() {
        subObject.methodA();
    }
}
