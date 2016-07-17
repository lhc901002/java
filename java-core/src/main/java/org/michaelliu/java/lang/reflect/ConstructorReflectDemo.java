package org.michaelliu.java.lang.reflect;

import org.michaelliu.java.entity.Account;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Michael on 2016/7/17.
 */
public class ConstructorReflectDemo {

    public static void main(String[] args) {
        Class<?> accountClass = null;
        try {
            accountClass = Class.forName("org.michaelliu.java.entity.Account");
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
        Account account1 = null;
        Account account2 = null;
        Constructor<?>[] constructors = accountClass.getConstructors();
        try {
            account1 = (Account)constructors[0].newInstance();
            account1.setId(1l);
            account1.setName("Michael");
            account2 = (Account)constructors[1].newInstance(123l, "Steven");
        } catch (InstantiationException e) {
            System.err.println(e);
        } catch (IllegalAccessException e) {
            System.err.println(e);
        } catch (InvocationTargetException e) {
            System.err.println(e);
        }
        System.out.println("account1: " + account1);
        System.out.println("account2: " + account2);
    }

}
