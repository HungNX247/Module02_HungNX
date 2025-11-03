package com.codegym.practice;

import java.util.Scanner;

public class CalculationExample {
    private static final Scanner scanner = new Scanner(System.in);

    private void calculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Tong x + y = " + a);
            System.out.println("Hieu x - y = " + b);
            System.out.println("Tich x * y = " + c);
            System.out.println("Thuong x / y = " + d);
        } catch (Exception e) {
            System.err.println("Xay ra ngoai le: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.print("Nhap x: ");
        int x = scanner.nextInt();
        System.out.print("Nhap y: ");
        int y = scanner.nextInt();
        CalculationExample calculationExample = new CalculationExample();
        calculationExample.calculate(x, y);
    }
}
