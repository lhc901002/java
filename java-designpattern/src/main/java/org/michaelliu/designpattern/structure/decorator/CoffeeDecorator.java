package org.michaelliu.designpattern.structure.decorator;

/**
 * Created by Michael on 7/4/16.
 */
public abstract class CoffeeDecorator extends Coffee {

    protected final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

}
