package org.michaelliu.demo.java.designpattern.creator.factory.abstractfactory;

/**
 * Created by Michael on 7/2/16.
 */
public class UIGenerator {

    public void makeAnimal(AbstractAnimalFactory animalFactory) {
        Animal animal = animalFactory.createAnimal();
        animal.grow();
        animal.eat();
        animal.run();
    }

}
