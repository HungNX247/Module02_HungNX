package com.codegym.wrapper_classes;

import java.util.ArrayList;

public class WrapperClassesExample {
    
    public static void main(String[] args) {
        // primitive data types: byte, short, int, long, float, double, boolean, char
        // Wrapper Class types: Byte, Short, Integer, Long, Float, Double, Boolean, Character

        // ArrayList<int> list = new ArrayList<>(); // Invalid
        ArrayList<Integer> list = new ArrayList<>(); // Valid

        // I. casting in Primitive Data types: 
        // 1. implicit casting: cast from smaller type to larger type
        // 2. explicit casting: cast from larger type to smaller type
        int a = 3;
        double b = a; // implicit casting
        System.out.println(a);
        System.out.println(b);

        double c = 5;
        int d = (int) c; // explicit casting
        System.out.println(c);
        System.out.println(d);

        // II. Boxing in Wrapper Class types:
        // 1. Auto-boxing: auto convert from Primitive Data type to Wrapper Class type
        // 2. Unboxing: convert from Wrapper Class type to Primitive Data type
        int e = 7;
        Integer f = Integer.parseInt(String.valueOf(e)); // Auto-boxing
        System.out.println(e);
        System.out.println(f);

        Integer g = 9;
        int h = g.intValue(); // Unboxing
        System.out.println(g);
        System.out.println(h);
    }
}
