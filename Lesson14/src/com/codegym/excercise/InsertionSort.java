package com.codegym.excercise;

public class InsertionSort {
    static int[] arrs = { 1, 9, 4, 6, 5, -4 };

    public static void insertionSort(int[] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            int key = arrs[i];
            int j = i - 1;

            while (j >= 0 && arrs[j] > key) {
                arrs[j + 1] = arrs[j];
                j--;
            }
            arrs[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        System.out.println("Before sorted: ");
        for (int arr : arrs) {
            System.out.print(arr + " ");
        }

        insertionSort(arrs);
        System.out.println();
        System.out.println("---------------------------------------");

        System.out.println("After sorted: ");
        for (int arr : arrs) {
            System.out.print(arr + " ");
        }
    }
}
