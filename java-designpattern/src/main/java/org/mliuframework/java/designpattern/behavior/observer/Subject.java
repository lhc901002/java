package org.mliuframework.java.designpattern.behavior.observer;

/**
 * Created by Michael on 7/4/16.
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

}
