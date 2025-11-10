package com.codegym.string;

// Immutable: bất biến -> String is immutable
public class StringIsImmutable {
    
    public static void main(String[] args) {
        // Example 1:
        // String s1 = "abc";
        // System.out.println(s1); // "abc"

        // String s2 = s1.toUpperCase();
        // System.out.println(s1); // "abc"
        // System.out.println(s2); // "ABC"

        // Example 2:
        String s3 = "abc";
        String s4 = s3;
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());

        String s5 = new String("abc");
        System.out.println(s3 == s5); // ? -> false
        System.out.println(s3.equals(s5)); // ? -> true
    }
}
