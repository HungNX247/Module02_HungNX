package com.codegym.excercise.triangle;

import java.util.Scanner;

public class TriangleTest {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.print("Nhap canh a: ");
            double a = scanner.nextDouble();
            System.out.print("Nhap canh b: ");
            double b = scanner.nextDouble();
            System.out.print("Nhap canh c: ");
            double c = scanner.nextDouble();

            checkTriangle(a, b, c);
            System.out.println("Day la 3 canh cua tam giac");
        } catch (IllegalTriangleException e) {
            System.err.println("Loi: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Du lieu khong hop le. Vui long nhap lai!");
        }

    }

    private static void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Canh tam giac phai lon hon 0!");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tong 2 canh phai lon hon canh con lai!");
        }
    }
}
