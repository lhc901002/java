package com.thread;

import java.util.Random;

public class MyThread2 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            Random random = new Random();
            random.nextInt();
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Thread 2 costs: " + (endTime - beginTime) + "ms");
    }
}
