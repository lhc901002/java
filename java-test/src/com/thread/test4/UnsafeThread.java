package com.thread.test4;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Michael on 3/31/17.
 */
public class UnsafeThread {
    public static void main(String[] args) throws InterruptedException {
        final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>(1000);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "AA");
                        }
                    }).start();
                }
            }
        });
        long start = System.currentTimeMillis();
        t.start();
        t.join();
        System.out.println(System.currentTimeMillis() - start);
    }
}
