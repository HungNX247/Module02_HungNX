package com.codegym.hungnx.lesson05.excercise.circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(3.5);
        circle1.getColor();
        circle2.setColor("blue");

        System.out.println("Circle1 - Radius: " + circle1.getRadius() + ", Area: " + circle1.getArea() + ", Color: "
                + circle1.getColor());
        System.out.println("Circle2 - Radius: " + circle2.getRadius() + ", Area: " + circle2.getArea() + ", Color: "
                + circle2.getColor());
    }
}
