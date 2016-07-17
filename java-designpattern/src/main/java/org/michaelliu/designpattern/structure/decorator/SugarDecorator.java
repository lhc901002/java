package org.michaelliu.designpattern.structure.decorator;

/**
 * Created by Michael on 7/4/16.
 */
public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getIngredients() {
        return decoratedCoffee.getIngredients() + ", sugar";
    }

    @Override
    public double cost() {
        return 0.2 + decoratedCoffee.cost();
    }

}
