package com.codegym.excercise.reverse;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5 };
        System.out.println("1.1 Initial Array: " + Arrays.toString(numbers));

        ReverseUsingStack.reverseArray(numbers);

        System.out.println("1.2 Array after reversed: " + Arrays.toString(numbers));

        String sentence = "Java Bootcamp 2.1";
        System.out.println("2.1. String: " + sentence);

        String reversed = ReverseUsingStack.reverseString(sentence);

        System.out.println("2.2. String after reversed: " + reversed);
    }
}
