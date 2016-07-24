package org.michaelliu.demo.java.designpattern.creator.prototype;

/**
 * Created by Michael on 7/4/16.
 */
public class Rectangle extends Shape {

    public Rectangle() {
        this.type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }

}
