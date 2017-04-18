package org.michaelliu.demo.java.thread.jmm;

/**
 * Created by Michael on 3/23/17.
 */
public class ReorderExample {

     int a = 0;
     int b = 0;
    volatile int r1 = 0;
    volatile int r2 = 0;

    public void method1() {
        r2 = a;
        b = 1;
    }

    public void method2() {
        r1 = b;
        a = 2;
    }

    public static void main(String[] args) {
        final ReorderExample obj = new ReorderExample();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.method1();
                System.out.println("r1=" + obj.r1);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.method2();
                System.out.println("r2=" + obj.r2);
            }
        });
        thread1.start();
        thread2.start();
//        System.out.println("a=" + obj.a);
//        System.out.println("b=" + obj.b);
//        System.out.println("r1=" + obj.r1);
//        System.out.println("r2=" + obj.r2);
    }
}
