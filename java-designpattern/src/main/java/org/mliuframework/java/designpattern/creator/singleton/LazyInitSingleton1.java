package org.mliuframework.java.designpattern.creator.singleton;

/**
 * Created by Michael on 7/2/16
 *
 * Lazy initialization means Singleton constructor will not be executed until
 * you call getInstance()
 */
public final class LazyInitSingleton1 {

    private static volatile LazyInitSingleton1 instance;

    private LazyInitSingleton1() { }

    public static LazyInitSingleton1 getInstance() {
        if (instance == null ) {
            synchronized (LazyInitSingleton1.class) {
                if (instance == null) {
                    instance = new LazyInitSingleton1();
                }
            }
        }
        return instance;
    }

}
