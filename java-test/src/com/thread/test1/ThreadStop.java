package com.thread.test1;

/**
 * Created by Michael on 3/27/17.
 */
public class ThreadStop implements Runnable {
    private MyService service;

    public ThreadStop(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.stopService();
    }
}
