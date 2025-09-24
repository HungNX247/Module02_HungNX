package Difficult_Exercises;

import java.util.Scanner;

public class SumNumberColumm {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int rows, cols;
        System.out.print("Enter number of rows: ");
        rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        cols = sc.nextInt();
        int[][] numbers = new int[rows][cols];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print("Enter element at position (" + i + "," + j + "): ");
                numbers[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter the column index to sum: ");
        int colIndex = sc.nextInt();
        if (colIndex < 0 || colIndex >= cols) {
            System.out.println("Invalid column index.");
        } else {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i][colIndex];
            }
            System.out.println("The sum of elements in column " + colIndex + " is: " + sum);
        }
        sc.close();
    }
}
