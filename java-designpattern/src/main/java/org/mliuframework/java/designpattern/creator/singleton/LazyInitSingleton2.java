package org.mliuframework.java.designpattern.creator.singleton;

/**
 * Created by Michael on 7/2/16.
 *
 * Lazy initialization means Singleton constructor will not be executed until
 * you call getInstance()
 */
public final class LazyInitSingleton2 {

    private static LazyInitSingleton2 instance = null;

    private LazyInitSingleton2() { }

    public static synchronized LazyInitSingleton2 getInstance() {
        if (instance == null) {
            instance = new LazyInitSingleton2();
        }
        return instance;
    }

}
