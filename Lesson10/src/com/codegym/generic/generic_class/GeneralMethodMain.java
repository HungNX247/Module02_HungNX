package com.codegym.generic.generic_class;

public class GeneralMethodMain {

    public static void main(String[] args ) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        String[] cities = {"London", "Paris", "New York", "Austin"};
        GeneralMethod.<Integer>print(numbers);
        GeneralMethod.<String>print(cities);
//        GeneralMethod generalMethod = new GeneralMethod();
//        generalMethod.print(cities);
    }
}
