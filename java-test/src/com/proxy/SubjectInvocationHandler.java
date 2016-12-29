package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectInvocationHandler implements InvocationHandler {

    /** 代理类包含一个委托类的对象引用 */
    private Subject delegate;

    public SubjectInvocationHandler(Subject delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        // 利用反射机制调用委托类方法。Method的invoke返回Object对象作为方法执行结果。
        Object retObj = method.invoke(delegate, args);
        long end = System.currentTimeMillis();
        System.out.println("执行任务耗时: " + (end - start) + "ms");
        return retObj;
    }
}
