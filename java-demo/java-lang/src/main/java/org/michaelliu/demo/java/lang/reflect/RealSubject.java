package org.michaelliu.demo.java.lang.reflect;

public class RealSubject {
    /**
     * 执行业务（休眠1秒钟）
     */
    public void doSomething() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
