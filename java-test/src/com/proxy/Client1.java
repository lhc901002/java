package com.proxy;

public class Client1 {
    public static void main(String[] args) {
//        Subject proxy = StaticProxyFactory.getInstance();
//        proxy.doSomething();  // print '执行任务耗时: 1003ms'
        Subject proxy = DynamicProxyFactory.getInstance();
        proxy.doSomething();  // print '执行任务耗时: 1003ms'
    }
}
