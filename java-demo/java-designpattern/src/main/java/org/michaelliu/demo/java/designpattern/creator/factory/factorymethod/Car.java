package org.michaelliu.demo.java.designpattern.creator.factory.factorymethod;

/**
 * Created by Michael on 7/2/16.
 */
public abstract class Car {

    private CarType model;

    public Car(CarType model) {
        this.model = model;
    }

    protected abstract void construct();

    public CarType getModel() {
        return model;
    }

    public void setModel(CarType model) {
        this.model = model;
    }

}
