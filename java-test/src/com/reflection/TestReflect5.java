package com.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect5 {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.reflection.User");
            // 调用无参print方法
            Method method1 = clazz.getMethod("print");
            method1.invoke(clazz.newInstance());  // id: null, name: null

            // 调用带参print方法
            Method method2 = clazz.getMethod("print", Integer.class, String.class);
            method2.invoke(clazz.newInstance(), 12345, "Michael");  // id: 12345, name: Michael

            // 调用private方法
            Method method3 = clazz.getDeclaredMethod("privatePrint", Integer.class, String.class);
            method3.setAccessible(true);
            method3.invoke(clazz.newInstance(), 12345, "Michael");  // id: 12345, name: Michael
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
