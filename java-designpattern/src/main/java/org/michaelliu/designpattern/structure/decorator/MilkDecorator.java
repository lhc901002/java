package org.michaelliu.designpattern.structure.decorator;

/**
 * Created by Michael on 7/4/16.
 */
public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getIngredients() {
        return decoratedCoffee.getIngredients() + ", milk";
    }

    @Override
    public double cost() {
        return 0.5 + decoratedCoffee.cost();
    }

}
