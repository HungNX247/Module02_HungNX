package com.codegym.comparable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int n = 4;
        Employee arr[] = new Employee[n];

        arr[0] = new Employee(1, "Bình", 19);
        arr[1] = new Employee(2, "An", 17);
        arr[2] = new Employee(3, "Duy", 18);
        arr[3] = new Employee(4, "Cường", 20);

        // Sorting the array
        Arrays.sort(arr);

        // printing the array
        print(arr);
    }

    public static void print(Employee[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
