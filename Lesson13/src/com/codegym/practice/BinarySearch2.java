package com.codegym.practice;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (high + low) / 2;
            if (key < list[mid]) {
                high = mid - 1;
            } else if (key == list[mid]) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.print("Nhap so luong phan tu: ");
        int size = scanner.nextInt();
        int[] list = new int[size];

        for (int i = 0; i < list.length; i++) {
            System.out.print("\nNhap phan tu thu " + (i + 1) + ": ");
            list[i] = scanner.nextInt();
        }

        Arrays.sort(list);
        System.out.print("\nMang sau khi nhap va sap xep lai: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
        System.out.print("Nhap gia tri can tim: ");
        int key = scanner.nextInt();
        int result = binarySearch(list, key);
        if (result == -1) {
            System.out.println("Khong tim thay gia tri can tim trong mang");
        } else {
            System.out.println("So can tim nam o vi tri " + (result + 1));
        }
    }
}
