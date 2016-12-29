package com.test;

import java.lang.reflect.Method;

public class TestPrivate {
    public static void main(String[] args) throws Exception {
        PrivateClass p = new PrivateClass();
        Class<?> classType = p.getClass();
        // 获取Method对象
        Method method = classType.getDeclaredMethod("sayHello", new Class[] { String.class });
        method.setAccessible(true); // 抑制Java的访问控制检查
        // 如果不加上上面这句，将会Error: TestPrivate can not access a member of class PrivateClass with modifiers "private"

        String str = (String) method.invoke(p, new Object[] { "Michael" });
        System.out.println(str);
    }
}
