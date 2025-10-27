package com.codegym.comparator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // Creating an empty ArrayList of Student type
        ArrayList<Student> ar = new ArrayList<Student>();

        // Adding entries in above List
        // using add() method
        ar.add(new Student(111, "Bình", "Sài Gòn"));
        ar.add(new Student(131, "An", "Đà Nẵng"));
        ar.add(new Student(121, "Duy", "Hà Nội"));
        ar.add(new Student(101, "Cường", "Cần Thơ"));

        // Display message on console for better readability
        System.out.println("Unsorted");

        // Iterating over entries to print them
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        // Sorting student entries by roll number
        Collections.sort(ar, new SortByRoll());

        // Display message on console for better readability
        System.out.println("\nSorted By RollNo");

        // Again iterating over entries to print them
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        // Sorting student entries by name
        Collections.sort(ar, new SortByName());

        // Display message on console for better readability
        System.out.println("\nSorted by Name");

        // // Again iterating over entries to print them
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));
    }
}
