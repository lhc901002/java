package org.michaelliu.demo.java.thread;

/**
 * Created by Michael on 3/22/17.
 */
public class InterruptThread implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10000; i++) {
                System.out.println("Loop round " + i);
                // Do some heavy jobs
                heavyJob();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted!");
            return;
        }
        System.out.println("InterruptThread finished");
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
