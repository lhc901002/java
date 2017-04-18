package com.thread;

public class ThreadB extends Thread {

//    private int count = 0;
//
//    public int getCount() {
//        return count;
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            count++;
//            if (Thread.interrupted()) {
//                return;
//            }
//        }
//    }

    private Exchanger exchanger;

    public ThreadB(Exchanger exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            int num = (int) exchanger.take();
            System.out.println("Thread B takes object: number " + num);
        }

    }
}
