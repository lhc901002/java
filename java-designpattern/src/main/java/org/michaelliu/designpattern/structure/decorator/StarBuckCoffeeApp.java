package org.michaelliu.designpattern.structure.decorator;

/**
 * Created by Michael on 7/4/16.
 */
public class StarBuckCoffeeApp {

    public static void main(String[] args) {
        Coffee coffee = new Expresso();
        coffee = new SugarDecorator(coffee);
        coffee = new MilkDecorator(coffee);
        System.out.println("Ingredient: " + coffee.getIngredients());
        System.out.println("Total cost: " + coffee.cost());
    }

}
