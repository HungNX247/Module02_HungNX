package com.codegym.stack;

import java.util.*;

class StackAccessing {

    // Main Method
    public static void main(String[] args) {

        // Default initialization of Stack
        Stack stack1 = new Stack();

        // Initialization of Stack
        // using Generics
        Stack<String> stack2 = new Stack<String>();

        // pushing the elements
        stack1.push(10);
        stack1.push("C10");
        stack1.push("Students");

        stack2.push("CodeGym");
        stack2.push("C10");
        stack2.push("Students");

        // Printing the Stack Elements
        System.out.println(stack1);
        System.out.println(stack2);
    }
}
