package com.codegym.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class IteratorExample04 {
    public static void main(String[] args) {
        // Create list with no parameter
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            // Add element to list
            list.add("0" + i);
        }

        Iterator<String> iterator = list.iterator();
        System.out.println("Before removing, list.isEmpty() = " + list.isEmpty());
        System.out.println("Using Iterator: Only Traversing the list "
                + "in the forward direction ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
            iterator.remove();
        }
        System.out.println();
        System.out.println("After removing, list.isEmpty() = " + list.isEmpty());
    }
}
