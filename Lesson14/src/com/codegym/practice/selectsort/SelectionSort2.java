package com.codegym.practice.selectsort;

import java.util.Scanner;

public class SelectionSort2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Nhap so luong phan tu cua mang: ");
        int size = scanner.nextInt();

        double[] numbers = new double[size];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Nhap phan tu thu " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println();
        System.out.println("Mang sau khi nhap: ");
        for (double number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println("--------------------------------");

        selectionSort(numbers);

        System.out.println("Mang sau khi sap xep: ");
        for (double number : numbers) {
            System.out.print(number + " ");
        }
    }

    public static void selectionSort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            double currentMin = arr[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (currentMin > arr[j]) {
                    currentMin = arr[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                arr[currentMinIndex] = arr[i];
                arr[i] = currentMin;
            }
        }
    }
}
