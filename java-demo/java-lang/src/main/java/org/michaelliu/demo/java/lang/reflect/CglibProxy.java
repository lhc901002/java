package org.michaelliu.demo.java.lang.reflect;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        // 设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        // 通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();
        // 通过代理类调用父类中的方法
        Object result = methodProxy.invokeSuper(o, objects);
        long end = System.currentTimeMillis();
        System.out.println("执行任务耗时: " + (end - start) + "ms");
        return result;
    }
}
