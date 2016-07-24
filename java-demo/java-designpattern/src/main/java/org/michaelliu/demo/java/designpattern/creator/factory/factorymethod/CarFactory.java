package org.michaelliu.demo.java.designpattern.creator.factory.factorymethod;

/**
 * Created by Michael on 7/2/16.
 */
public class CarFactory {

    public static Car buildCar(CarType model) {
        Car car = null;
        switch (model) {
            case SMALL:
                car = new SmallCar();
                break;
            case SEDAN:
                car = new SedanCar();
                break;
            case LUXURY:
                car = new LuxuryCar();
                break;
            default:
                break;
        }
        return car;
    }

}
