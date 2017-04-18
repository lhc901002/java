package com.thread;

import java.util.Random;

public class MyThread1 extends Thread {
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
        System.out.println("Thread 1 costs: " + (endTime - beginTime) + "ms");

    }

	public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread1 thread1 = new MyThread1();
            thread1.setPriority(6);
            thread1.start();
            MyThread2 thread2 = new MyThread2();
            thread2.setPriority(5);
            thread2.start();
        }
	}
}
