package com.reflection;

import java.lang.reflect.Field;

public class TestReflect4 {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.reflection.User");
            Object obj = clazz.newInstance();
            // 对属性赋值（包括private属性）
            Field field = clazz.getDeclaredField("id");
            field.setAccessible(true);
            field.set(obj, 10086);
            Field field2 = clazz.getDeclaredField("name");
            field2.setAccessible(true);
            field2.set(obj, "Michael");
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
