package org.michaelliu.demo.java.designpattern.creator.factory.abstractfactory;

/**
 * Created by Michael on 7/2/16.
 */
public class Cat implements Animal {

    public Cat() {
        System.out.println("A new cat!");
    }

    @Override
    public void grow() {
        System.out.println("Cats grow!");
    }

    @Override
    public void run() {
        System.out.println("Cats run!");
    }

    @Override
    public void eat() {
        System.out.println("Cats eat fish!");
    }

}
