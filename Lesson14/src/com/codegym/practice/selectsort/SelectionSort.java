package com.codegym.practice.selectsort;

public class SelectionSort {
    static double[] list = { 1, 9, 4.5, 6.6, 5.7, -4.5 };

    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            double currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Before sorted: ");
        for (double lists : list) {
            System.out.print(lists + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------");
        selectionSort(list);

        System.out.println("After sorted: ");
        for (double lists : list) {
            System.out.print(lists + " ");
        }
    }
}
