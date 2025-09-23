import java.util.Scanner;

public class NumberArray {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int size;
        int[] numbers;

        do {
            System.out.println("Enter the size of the array (max 20): ");
            size = sc.nextInt();
            if (size > 20) {
                System.out.println("Size exceeds the maximum limit of 20.");
            }
        } while (size > 20);
        numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }
        System.out.println("Array elements are: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " ");
        }

        int max = numbers[0];
        int indexOfMax = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                indexOfMax = i + 1;
            }
        }
        System.out.println("The largest number is " + max + " at index " + indexOfMax + ".");
        sc.close();
    }
}
