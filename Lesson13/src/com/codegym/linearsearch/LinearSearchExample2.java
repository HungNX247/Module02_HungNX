package com.codegym.linearsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinearSearchExample2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.print("Enter number of elements in array: ");
        int n = scanner.nextInt();
        int arr[] = new int[n];

        inputArray(arr);

        System.out.print("Please enter number want to find: ");
        int element = scanner.nextInt();

        List<Integer> result = linearSearch(arr, element);
        if (result.isEmpty())
            System.out.print("Element is not present in array");
        else {
            for (Integer index: result) {
                System.out.println("Element is present at index " + index);
            }
        }
            
    }

    private static void inputArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter element arr[" + i + "]: ");
            arr[i] = scanner.nextInt();
        }
    }

    public static List<Integer> linearSearch(int arr[], int value) {
        List<Integer> positions = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                positions.add(i);
            }
        }
        return positions;
    }
}
