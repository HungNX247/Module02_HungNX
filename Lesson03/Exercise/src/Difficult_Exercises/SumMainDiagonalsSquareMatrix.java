package Difficult_Exercises;

import java.util.Scanner;

public class SumMainDiagonalsSquareMatrix {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the size of the n x n matrix: ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];
        System.out.println("Enter the elements of the matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("matrix[%d][%d] = ", i, j);
                matrix[i][j] = sc.nextInt();
            }
        }

        int sumMainDiagonal = 0;
        int sumSecondaryDiagonal = 0;
        for (int i = 0; i < n; i++) {
            sumMainDiagonal += matrix[i][i];
            sumSecondaryDiagonal += matrix[i][n - 1 - i];
        }
        System.out.println("Sum of main diagonals = " + sumMainDiagonal);
        System.out.println("Sum of the secondary diagonals = " + sumSecondaryDiagonal);

        sc.close();
    }
}
