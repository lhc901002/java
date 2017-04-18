package com.thread.test1;

/**
 * Created by Michael on 3/27/17.
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyService service = new MyService();
            Thread a = new Thread(new ThreadRun(service));
            a.start();
            Thread.sleep(1000);
            Thread b = new Thread(new ThreadStop(service));
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
