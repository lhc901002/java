package org.michaelliu.demo.java.designpattern.creator.singleton;

/**
 * Created by Michael on 7/2/16.
 *
 * Eager initialization means that once JVM loads Singleton, its constructor
 * might be executed
 */
public final class EagerInitSingleton {

    private static final EagerInitSingleton INSTANCE = new EagerInitSingleton();

    private EagerInitSingleton() {}

    public static EagerInitSingleton getInstance() {
        return INSTANCE;
    }

}
