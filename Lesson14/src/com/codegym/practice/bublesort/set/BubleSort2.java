package com.codegym.practice.bublesort.set;

public class BubleSort2 {
    static int[] arr = { 2, 3, 2, 5, 6, 1, -2, 3, 14, 12 };

    public static void bubleSort(int[] arr) {
        boolean needNextPass = true;

        for (int k = 1; k < arr.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < arr.length - k; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    needNextPass = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Before sorted: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        bubleSort(arr);
        System.out.println("--------------------------------------------");

        System.out.println("After sorted: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
