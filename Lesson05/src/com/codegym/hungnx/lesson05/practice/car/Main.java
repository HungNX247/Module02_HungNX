package com.codegym.hungnx.lesson05.practice;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Mazda 3", "Skyactiv 3");
        car1.getName();
        System.out.println(Car.numberOfCars);
        Car car2 = new Car("Mazda 6", "Skyactiv 6");
        car2.getEngine();
        System.out.println(Car.numberOfCars);
    }
}
