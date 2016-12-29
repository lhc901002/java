package com.reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestReflect6 {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.reflection.User");
            // 调用无参、private Constructor
            Constructor cons1 = clazz.getDeclaredConstructor();
            cons1.setAccessible(true);
            User user1 = (User) cons1.newInstance();
            System.out.println(user1);  // User{id=null, name='null'}

            // 调用带参、private Constructor
            Constructor cons2 = clazz.getDeclaredConstructor(new Class[] { Integer.class, String.class });
            cons2.setAccessible(true);
            User user2 = (User) cons2.newInstance(1000, "Michael");
            System.out.println(user2); // User{id=1000, name='Michael'}
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
