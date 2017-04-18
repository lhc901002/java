package org.michaelliu.demo.java.thread;

/**
 * Created by Michael on 3/22/17.
 */
public class InterruptThread implements Runnable {
//    @Override
//    public void run() {
//        try {
//            for (int i = 1; i <= 10000; i++) {
//                // Do some heavy jobs
//                heavyJob();
//            }
//        } catch (InterruptedException e) {
//            System.out.println("Thread is interrupted!");
//            return;
//        }
//        System.out.println("Thread finished");
//    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println(Thread.interrupted());
            System.out.println(Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptThread());
        thread.start();
        thread.interrupt();
    }

    private void heavyJob() throws InterruptedException {
        // ...
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }
}
