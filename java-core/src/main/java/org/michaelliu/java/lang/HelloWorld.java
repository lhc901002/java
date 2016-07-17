package org.michaelliu.java.lang;

/**
 * Created by Michael on 2016/7/17.
 */
public class HelloWorld {

    public static void main(String[] args) {
        HelloWorld hello = new HelloWorld();
        Class c = hello.getClass();
        ClassLoader loader = c.getClassLoader();
        System.out.println(loader); // call AppClassLoader
        System.out.println(loader.getParent()); // call ExtClassLoader
        System.out.println(loader.getParent().getParent()); // call BootstrapClassLoader, because it is implemented using C, so no proper Java Class found, returns null.
    }

}
