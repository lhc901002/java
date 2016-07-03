package org.mliuframework.demo.designpattern.creator.factory.factorymethod;

/**
 * Created by Michael on 7/2/16.
 */
public class SmallCar extends Car {

    public SmallCar() {
        super(CarType.SMALL);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building small car");
    }

}
