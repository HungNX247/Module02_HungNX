package com.codegym.generic.generic_class;

public class GeneralMethod {

    public static <E> Integer print(E[] list) {
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
        return 0;
    }

    public static String test() {
        return "Hello";
    }
}
