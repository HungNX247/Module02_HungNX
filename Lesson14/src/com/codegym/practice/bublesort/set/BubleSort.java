package com.codegym.practice.bublesort.set;

import java.util.Scanner;

public class BubleSort {
    private static final Scanner scanner = new Scanner(System.in);

    public static void bubleSort(final int[] list) {
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    final int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }
            if (needNextPass == false) {
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }
        }
    }

    public static void main(final String[] args) {
        System.out.print("Enter elements numbers:");
        final int n = scanner.nextInt();
        final int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element at postition " + (i + 1) + ": ");
            list[i] = scanner.nextInt();
        }
        System.out.println("Before sorted: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
        bubleSort(list);
        System.out.println("--------------------------------------------- ");
        System.out.println("After sorted: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }

        scanner.close();
    }
}
