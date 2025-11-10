package com.codegym.string;

import java.util.Scanner;

public class StringExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();

        // clean up
        fullName = fullName.trim();
        fullName = fullName.replaceAll("\\s+", " ");
        fullName = fullName.substring(0, 1).toUpperCase() + fullName.substring(1);

        System.out.println("Standardized name: " + fullName);

        if (fullName.length() < 3) {
            System.out.println("Name too short!");
        } else {
            System.out.println("Valid name!");
        }

        scanner.close();
    }
}
