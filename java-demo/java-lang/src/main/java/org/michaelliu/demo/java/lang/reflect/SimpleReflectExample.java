package org.michaelliu.demo.java.lang.reflect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.demo.java.beans.Account;

/**
 * Created by Michael on 2016/7/17.
 */
public class SimpleReflectExample {

    private static Log log = LogFactory.getLog(SimpleReflectExample.class);

    public static void main(String[] args) {
        Class<?> accountClass = null;
        try {
            accountClass = Class.forName("org.michaelliu.demo.java.beans.Account");
        } catch (ClassNotFoundException e) {
            log.error(e);
        }
        log.info(accountClass.getName());
        Account account = null;
        try {
            /**
             * Account should contain constructor without parameter, otherwise
             * it will throw java.lang.InstantiationException
             */
            account = (Account) accountClass.newInstance();
        } catch (InstantiationException e) {
            log.error(e);
        } catch (IllegalAccessException e) {
            log.error(e);
        }
        account.setId(123l);
        account.setName("Michael");
        log.info(account);
    }

}
