package com.codegym.practice;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    private static final Scanner scanner = new Scanner(System.in);

    public Integer[] createRandom() {
        Random random = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("Danh sach phan tu cua mang: ");
        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] arr = arrayExample.createRandom();

        System.out.print("\nNhap chi so cua mot phan tu bat ky: ");
        int x = scanner.nextInt();

        try {
            System.out.println("Gia tri cua phan tu co chi so  " + x + " la: " + arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Chi so vuot qua gioi han cua mang");
        }
    }
}
