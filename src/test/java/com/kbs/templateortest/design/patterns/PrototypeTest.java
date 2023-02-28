package com.kbs.templateortest.design.patterns;

import com.kbs.templateortest.design.patterns.prototype.Circle;
import com.kbs.templateortest.design.patterns.prototype.Rectangle;
import com.kbs.templateortest.design.patterns.prototype.Shape;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PrototypeTest {

    @Test
    public void test() {
        ArrayList<Shape> shapes = new ArrayList<>();
        ArrayList<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 5;
        circle.y = 10;
        circle.radius = 15;
        circle.color = "green";
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        for(Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            System.out.println("[[[equals["+i +"] = "+ shapes.get(i).equals(shapesCopy.get(i)));
        }
    }
}
