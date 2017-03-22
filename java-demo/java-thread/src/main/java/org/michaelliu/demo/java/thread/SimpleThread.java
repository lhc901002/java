package org.michaelliu.demo.java.thread;

/**
 * Created by Michael on 3/22/17.
 */
public class SimpleThread {

    public static void main(String[] args) throws InterruptedException {
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run new thread!");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("New thread finished!");
            }
        });
        newThread.start();
        System.out.println("Run main thread!");
        newThread.join(1000);  // Main thread suspended, waiting for newThread to finish
        System.out.println("Main thread finished!");
    }
}
