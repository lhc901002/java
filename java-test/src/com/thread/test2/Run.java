package com.thread.test2;

/**
 * Created by Michael on 3/31/17.
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyObject obj = new MyObject();
            new Thread(new ThreadA(obj)).start();
            Thread.sleep(500);
            new Thread(new ThreadB(new MyObject())).start();
            new Thread(new ThreadC(obj)).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
