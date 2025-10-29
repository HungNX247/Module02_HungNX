package com.codegym.excercise;

import java.util.Scanner;

public class InsertionSort2 {
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

        insertionSort(numbers);

        System.out.println("Mang sau khi sap xep: ");
        for (double number : numbers) {
            System.out.print(number + " ");
        }
    }

    public static void insertionSort(double[] arrs) {

        for (int i = 1; i < arrs.length; i++) {
            double key = arrs[i];
            int j = i - 1;

            while (j >= 0 && arrs[j] > key) {
                arrs[j + 1] = arrs[j];
                j--;
            }
            arrs[j + 1] = key;
        }
    }
}
