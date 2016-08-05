package org.michaelliu.demo.java.thread.cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Michael on 8/5/16.
 */
public class CasCounter {

    private CasValue value;

    public CasCounter() {
        value = new CasValue();
    }

    public int getValue() {
        return value.getValue();
    }

    public int incrementAndGet() {
        int value;
        do {
            value = this.value.getValue();
        } while (value != this.value.compareAndSwap(value, value + 1));
        return value + 1;
    }

    public static void main(String[] args) {
        final CasCounter casCounter = new CasCounter();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    int result = casCounter.incrementAndGet();
                    System.out.println(result);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if (!executor.isShutdown()) {
            executor.shutdown();
        }
    }

}
