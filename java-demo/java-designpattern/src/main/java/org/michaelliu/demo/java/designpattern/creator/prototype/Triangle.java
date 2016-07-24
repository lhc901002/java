package org.michaelliu.demo.java.designpattern.creator.prototype;

/**
 * Created by Michael on 7/4/16.
 */
public class Triangle extends Shape {

    public Triangle() {
        this.type = "Triangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Triangle::draw() method.");
    }

}
