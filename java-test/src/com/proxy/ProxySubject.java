package com.proxy;

public class ProxySubject implements Subject {

    /** 代理类包含一个委托类的对象引用 */
    private Subject delegate;

    public ProxySubject(Subject delegate) {
        this.delegate = delegate;
    }

    /**
     * 将请求分派给委托类执行，记录任务执行前后的时间，时间差即为任务的处理时间。
     */
    @Override
    public void doSomething() {
        long start = System.currentTimeMillis();
        // 调用委托类方法
        delegate.doSomething();
        long end = System.currentTimeMillis();
        System.out.println("执行任务耗时: " + (end - start) + "ms");
    }
}
