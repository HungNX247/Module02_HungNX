package com.codegym.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class BinarySearchExample1 {
    private static final Scanner scanner = new Scanner(System.in);

    public static int binarySearch(int arr[], int x) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (arr[middle] == x) {
                return middle;
            }

            if (arr[middle] < x) left = middle + 1;
            else right = middle - 1;
        }

        return -1;
    }

    public static void main(String args[]) {
        System.out.print("Enter number of elements in list: ");
        Integer n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();
        inputNumbers(numbers, n);
        Collections.sort(numbers);

        displaySortedNumbers(numbers);

        System.out.print("Please enter number want to find: ");
        int findingElement = scanner.nextInt();

        int[] intArray = getIntArray(numbers);

        int result = binarySearch(intArray, findingElement);
        if (result == -1)
            System.out.println("Element not present in array");
        else 
            System.out.println("Element found at index " + result);
            
    }

    private static void displaySortedNumbers(List<Integer> numbers) {
        System.out.print("List of numbers after sorting is: ");
        for (Integer element: numbers) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static int[] getIntArray(List<Integer> numbers) {
        Integer[] integerArray = numbers.toArray(new Integer[0]);
        int[] intArray = new int[integerArray.length];

        for (int i = 0; i < integerArray.length; i++) {
            intArray[i] = integerArray[i];
        }
        return intArray;
    }

    private static void inputNumbers(List<Integer> numbers, Integer n) {
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element at index " + i + ": ");
            Integer inputNumber = scanner.nextInt();
            numbers.add(inputNumber);
        }
    }
}
