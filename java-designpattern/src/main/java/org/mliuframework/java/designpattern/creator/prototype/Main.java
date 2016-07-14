package org.mliuframework.java.designpattern.creator.prototype;

/**
 * Created by Michael on 7/4/16.
 */
public class Main {

    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape clonedShape = (Shape) ShapeCache.getShape(1l);
        System.out.println("Shape: " + clonedShape.getType());
        Shape clonedShape2 = (Shape) ShapeCache.getShape(2l);
        System.out.println("Shape: " + clonedShape2.getType());
        Shape clonedShape3 = (Shape) ShapeCache.getShape(3l);
        System.out.println("Shape: " + clonedShape3.getType());
    }

}
