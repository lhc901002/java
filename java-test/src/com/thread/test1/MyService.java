package com.thread.test1;

/**
 * Created by Michael on 3/27/17.
 */
public class MyService {
    private boolean isRunning = true;

    public synchronized boolean getIsRunning() {
        return isRunning;
    }

    public void runService() {
        System.out.println("MyService starts running!");
        while (isRunning) {
            synchronized (this) {

            }
            // MyService is running
        }
        System.out.println("MyService stops running!");
    }

    public void stopService() {
        isRunning = false;
    }
}
