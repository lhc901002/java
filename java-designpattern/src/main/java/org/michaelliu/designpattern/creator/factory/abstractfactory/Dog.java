package org.michaelliu.designpattern.creator.factory.abstractfactory;

/**
 * Created by Michael on 7/2/16.
 */
public class Dog implements Animal {

    public Dog() {
        System.out.println("A new dog!");
    }

    @Override
    public void grow() {
        System.out.println("Dogs grow!");
    }

    @Override
    public void run() {
        System.out.println("Dogs run!");
    }

    @Override
    public void eat() {
        System.out.println("Dogs eat bone!");
    }

}
