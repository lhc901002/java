package org.mliuframework.demo.designpattern.structure.singleton;

/**
 * Created by Michael on 7/2/16.
 *
 * Static block initialization puts initial process within static
 * block, once JVM loads Singleton, its constructor might be executed.
 */
public class StaticBlockInitSingleton {

    private static final StaticBlockInitSingleton instance;

    static {
        try {
            instance = new StaticBlockInitSingleton();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred when calling constructor!", e);
        }
    }

    private StaticBlockInitSingleton() {}

    public static StaticBlockInitSingleton getInstance() {
        return instance;
    }
    
}
