package Difficult_Exercises;

import java.util.Scanner;

public class CountCharacterInString {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.print("Enter the character to count: ");
        char ch = sc.next().charAt(0);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        System.out.println("The character " + ch + " appears " + count + " times in the string.");

        sc.close();
    }
}
