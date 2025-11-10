package com.codegym.regular_expression;

import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        String email = "daonbm@gmail.com";
        String phone = "09051234567";
        String orderCode = "DH20251107";

        // Check email format
        boolean isValidEmail = Pattern.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", email);
        System.out.println("Valid email: " + isValidEmail);

        // Check Vietnamese phone number format
        boolean isValidPhone = Pattern.matches("^(0[3|5|7|8|9])+([0-9]{8})$", phone);
        System.out.println("Valid phone number: " + isValidPhone);

        // Check order code format (DH + 8 digits)
        boolean isValidOrder = Pattern.matches("^DH\\d{8}$", orderCode);
        System.out.println("Valid order code: " + isValidOrder);
    }
}
