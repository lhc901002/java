package com.thread;

public class ThreadA extends Thread {

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
//
//    public static void main(String[] args) {
//        try {
//            ThreadA a = new ThreadA();
//            a.setPriority(10);
//            a.start();
//            ThreadB b = new ThreadB();
//            b.setPriority(1);
//            b.start();
//
//            Thread.sleep(20000);
//            a.interrupt();
//            b.interrupt();
//
//            System.out.println("a=" + a.getCount());
//            System.out.println("b=" + b.getCount());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    private Exchanger exchanger;

    public ThreadA(Exchanger exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10000; i++) {
                System.out.println("Thread A puts object: number " + i);
                exchanger.put(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
