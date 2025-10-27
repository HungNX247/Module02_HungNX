package com.codegym.linearsearch;

public class LinearSearchExample1 {

    public static void main(String args[]) {
        int arr[] = { 2, 40, 3, 4, 10, 50 };
        int x = 70;

        int result = linearSearch(arr, x);
        if (result == -1)
            System.out.print("Element is not present in array");
        else
            System.out.print("Element is present at index " + result);
    }

    public static int linearSearch(int arr[], int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }
}
