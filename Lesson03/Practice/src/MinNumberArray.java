import java.util.Scanner;

public class MinNumberArray {
    private static Scanner sc = new Scanner(System.in);

    public static int findMin(int[] array) {
        int min = array[0];
        int indexOfMin = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }

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
            System.out.println(numbers[i] + " ");
        }
        int indexOfMin = findMin(numbers);
        System.out.println("The smallest number is " + numbers[indexOfMin] + " at index " + (indexOfMin + 1) + ".");

        sc.close();

    }
}
