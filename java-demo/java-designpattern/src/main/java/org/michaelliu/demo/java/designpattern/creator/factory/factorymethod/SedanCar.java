package org.michaelliu.demo.java.designpattern.creator.factory.factorymethod;

/**
 * Created by Michael on 7/2/16.
 */
public class SedanCar extends Car {

    public SedanCar() {
        super(CarType.SEDAN);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building sedan car");
    }
}
