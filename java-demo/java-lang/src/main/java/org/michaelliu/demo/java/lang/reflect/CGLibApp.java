package org.michaelliu.demo.java.lang.reflect;

public class CGLibApp {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        RealSubject subject = (RealSubject) proxy.getProxy(RealSubject.class);
        subject.doSomething();
    }
}
