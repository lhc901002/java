package org.mliuframework.java.designpattern.creator.prototype;

/**
 * Created by Michael on 7/4/16.
 */
public class Circle extends Shape {

    public Circle() {
        this.type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

}
