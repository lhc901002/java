package org.michaelliu.java.lang.reflect;

import org.michaelliu.java.entity.Account;

/**
 * Created by Michael on 2016/7/17.
 */
public class SimpleReflectDemo {

    public static void main(String[] args) {
        Class<?> accountClass = null;
        try {
            accountClass = Class.forName("org.michaelliu.java.entity.Account");
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
        System.out.println(accountClass.getName());
        Account account = null;
        try {
            /**
             * Account should contain constructor without parameter, otherwise
             * it will throw java.lang.InstantiationException
             */
            account = (Account)accountClass.newInstance();
        } catch (InstantiationException e) {
            System.err.println(e);
        } catch (IllegalAccessException e) {
            System.err.println(e);
        }
        account.setId(123l);
        account.setName("Michael");
        System.out.println(account);
    }

}
