package com.codegym.excercise.reverse;

import java.util.Stack;

public class ReverseUsingStack {
    public static void reverseArray(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            stack.push(num);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

    public static String reverseString(String input) {

        Stack<String> stack = new Stack<>();

        String[] words = input.split(" ");

        for (String word : words) {
            stack.push(word);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
            if (!stack.isEmpty()) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }
}
