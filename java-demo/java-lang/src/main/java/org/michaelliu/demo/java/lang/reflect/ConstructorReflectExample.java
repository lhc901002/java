package org.michaelliu.demo.java.lang.reflect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.demo.java.beans.Account;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Michael on 2016/7/17.
 */
public class ConstructorReflectExample {

    private static Log log = LogFactory.getLog(ConstructorReflectExample.class);

    public static void main(String[] args) {
        Class<?> accountClass = null;
        try {
            accountClass = Class.forName("org.michaelliu.demo.java.beans.Account");
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
        Account account1 = null;
        Account account2 = null;
        Constructor<?>[] constructors = accountClass.getConstructors();
        try {
            account1 = (Account) constructors[0].newInstance();
            account1.setId(1l);
            account1.setName("Michael");
            account2 = (Account) constructors[1].newInstance(123l, "Steven");
        } catch (InstantiationException e) {
            log.error(e);
        } catch (IllegalAccessException e) {
            log.error(e);
        } catch (InvocationTargetException e) {
            log.error(e);
        }
        log.info("account1: " + account1);
        log.info("account2: " + account2);
    }

}
