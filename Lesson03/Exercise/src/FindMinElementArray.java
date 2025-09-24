import java.util.Scanner;

public class FindMinElementArray {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int size;
        int[] numbers;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();
        numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }
        System.out.println("Array elements are: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        int min = numbers[0];
        int indexOfMin = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
                indexOfMin = i;
            }
        }
        System.out.println("\nThe smallest number is " + numbers[indexOfMin] + " at index " + (indexOfMin + 1) + ".");

        sc.close();
    }
}
