package com.proxy;

public class RealSubject implements Subject {
    /**
     * 执行业务（休眠1秒钟）
     */
    @Override
    public void doSomething() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
