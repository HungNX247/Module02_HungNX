import java.util.Scanner;

public class FindLargestElementTwoDimensionalArray {
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
        int max = numbers[0][0];
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] > max) {
                    max = numbers[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println("The largest element is " + max + " at position (" + maxRow + "," + maxCol + ").");
        sc.close();
    }
}
