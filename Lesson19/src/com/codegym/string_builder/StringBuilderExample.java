package com.codegym.string_builder;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder emailContent = new StringBuilder();

        emailContent.append("Hello ").append("Mr. Dao").append(",\n\n");
        emailContent.append("Thank you for using our service.\n");
        emailContent.append("Here is your order information:\n");
        emailContent.append("- Order Code: DH20251107\n");
        emailContent.append("- Total Amount: 1,500,000 VND\n\n");
        emailContent.append("Best regards,\n");
        emailContent.append("Sea Turtle CRM Team");

        System.out.println(emailContent.toString());
    }
}
