package org.mliuframework.demo.designpattern.structure.decorator;

/**
 * Created by Michael on 7/4/16.
 */
public class Expresso extends Coffee {

    public Expresso() {
        description = "Expresso";
    }

    @Override
    public String getIngredients() {
        return "Expresso Coffee";
    }

    @Override
    public double cost() {
        return 1.99;
    }

}
