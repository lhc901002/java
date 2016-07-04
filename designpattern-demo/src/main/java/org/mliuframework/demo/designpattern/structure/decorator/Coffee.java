package org.mliuframework.demo.designpattern.structure.decorator;

/**
 * Created by Michael on 7/4/16.
 */
public abstract class Coffee {

    protected String description = "Simple Coffee";

    public String getDescription() {
        return description;
    }

    public abstract String getIngredients();

    public abstract double cost();

}
