package com.codegym.generic.generic_class;

import java.util.HashMap;

public class GeneralTypeMain {
    public static void main(String[] args) {
        // instance of Integer type
        GeneralType<Integer> iObj = new GeneralType<>(10);
        System.out.println(iObj.getProperty());

        // instance of String type
        GeneralType<String> sObj = new GeneralType<>("CodeGym-C10");
        System.out.println(sObj.getProperty());
    }
}
