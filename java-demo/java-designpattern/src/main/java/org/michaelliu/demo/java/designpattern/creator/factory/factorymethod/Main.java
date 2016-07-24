package org.michaelliu.demo.java.designpattern.creator.factory.factorymethod;

/**
 * Created by Michael on 7/2/16.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(CarFactory.buildCar(CarType.SMALL));
        System.out.println(CarFactory.buildCar(CarType.SEDAN));
        System.out.println(CarFactory.buildCar(CarType.LUXURY));
    }

}
