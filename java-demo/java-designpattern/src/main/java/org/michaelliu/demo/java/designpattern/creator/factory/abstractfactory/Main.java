package org.michaelliu.demo.java.designpattern.creator.factory.abstractfactory;

/**
 * Created by Michael on 7/2/16.
 */
public class Main {

    public static void main(String[] args) {
        UIGenerator generator = new UIGenerator();
        generator.makeAnimal(new CatFactory());
        generator.makeAnimal(new DogFactory());
    }

}
