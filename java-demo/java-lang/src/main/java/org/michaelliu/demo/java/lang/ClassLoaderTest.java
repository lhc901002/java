package org.michaelliu.demo.java.lang;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Michael on 2016/7/17.
 */
public class ClassLoaderTest {

    private static Log log = LogFactory.getLog(ClassLoaderTest.class);

    public static void main(String[] args) {
        ClassLoaderTest loaderTest = new ClassLoaderTest();
        Class c = loaderTest.getClass();
        ClassLoader loader = c.getClassLoader();
        // call AppClassLoader
        log.info(loader);
        // call ExtClassLoader
        log.info(loader.getParent());
        /**
         * call BootstrapClassLoader, because it is implemented using C,
         * so no proper Java Class found, returns null.
         */
        log.info(loader.getParent().getParent());
    }

}
