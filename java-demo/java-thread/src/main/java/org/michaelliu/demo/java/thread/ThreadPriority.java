package org.michaelliu.demo.java.thread;

/**
 * Created by Michael on 3/23/17.
 */
public class ThreadPriority {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
//            int priority = i > 5 ? Thread.MAX_PRIORITY : Thread.MIN_PRIORITY;
//            Thread thread = new Thread(new MyThread(i, 1));
//            thread.start();

        }
    }
}

//class MyThread implements Runnable {
//
//    int id;
//    int priority;
//
//    MyThread(int id, int priority) {
//        this.id = id;
//        this.priority = priority;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Thread id: " + id + " priority: " + priority);
//    }
//}
