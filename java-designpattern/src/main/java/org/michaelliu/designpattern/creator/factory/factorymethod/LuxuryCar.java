package org.michaelliu.designpattern.creator.factory.factorymethod;

/**
 * Created by Michael on 7/2/16.
 */
public class LuxuryCar extends Car {

    public LuxuryCar() {
        super(CarType.LUXURY);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building luxury car");
    }

}
