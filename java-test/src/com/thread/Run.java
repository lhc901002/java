package com.thread;

/**
 * Created by Michael on 3/24/17.
 */
public class Run {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        ThreadA a = new ThreadA(exchanger);
        ThreadB b = new ThreadB(exchanger);
        a.start();
        b.start();
    }
}
