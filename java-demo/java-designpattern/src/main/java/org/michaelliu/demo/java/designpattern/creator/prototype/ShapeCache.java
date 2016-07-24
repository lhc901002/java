package org.michaelliu.demo.java.designpattern.creator.prototype;

import java.util.Hashtable;

/**
 * Created by Michael on 7/4/16.
 */
public class ShapeCache {

    private static Hashtable<Long, Shape> shapeMap  = new Hashtable<Long, Shape>();

    public static Shape getShape(Long shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    /**
     * for each shape run database query and create shape
     * shapeMap.put(shapeKey, shape);
     * for example, we are adding three shapes
     */
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId(1l);
        shapeMap.put(circle.getId(), circle);

        Triangle triangle = new Triangle();
        triangle.setId(2l);
        shapeMap.put(triangle.getId(), triangle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId(3l);
        shapeMap.put(rectangle.getId(), rectangle);
    }

}
