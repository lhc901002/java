package org.michaelliu.demo.java.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by Michael on 3/23/17.
 */
public class ThreadState implements Runnable {

    public synchronized void method() {
        while (true) {
            // Do something
        }
    }

    @Override
    public void run() {
        method();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        System.out.println(thread.getId() + " " + thread.getState());
    }

//    public static void main(String[] args) throws InterruptedException {
//        Runnable obj = new ThreadState();
//        Thread thread1 = new Thread(obj, "thread1");
//        Thread thread2 = new Thread(obj, "thread2");
//        thread1.start();
//        thread2.start();
//        System.out.println(thread1.getName() + ": " + thread1.getState());
//        System.out.println(thread2.getName() + ": " + thread2.getState());
//
//    }

//    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10000000; i++) {
//
//                }
//            }
//        });
//        System.out.println(thread.getState());  // print 'NEW'
//        thread.start();
//        System.out.println(thread.getState());  // print 'RUNNABLE'
//        Thread.sleep(2000);  // Waiting for thread to terminate
//        System.out.println(thread.getState());  // print 'TERMINATED'
//    }
}
