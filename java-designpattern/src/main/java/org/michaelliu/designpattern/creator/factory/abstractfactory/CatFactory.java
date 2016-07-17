package org.michaelliu.designpattern.creator.factory.abstractfactory;

/**
 * Created by Michael on 7/2/16.
 */
public class CatFactory implements AbstractAnimalFactory {

    @Override
    public Animal createAnimal() {
        return new Cat();
    }

}
