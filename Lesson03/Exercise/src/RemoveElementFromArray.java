import java.util.Scanner;

public class RemoveElementFromArray {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int size;
        int[] numbers;
        System.out.println("Enter the size of the array: ");
        size = sc.nextInt();
        numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }
        System.out.println("Array elements are: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " ");
        }
        System.out.println("Enter value to remove: ");
        int valueToRemove = sc.nextInt();

        int indexToRemove = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == valueToRemove) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove == -1) {
            System.out.println("Value not found in the array.");
        } else {
            int[] newArray = new int[numbers.length - 1];
            for (int i = 0, j = 0; i < numbers.length; i++) {
                if (i != indexToRemove) {
                    newArray[j++] = numbers[i];
                }
            }
            System.out.println("Array after removing " + valueToRemove + ": ");
            for (int i = 0; i < newArray.length; i++) {
                System.out.println(newArray[i] + " ");
            }
        }
        sc.close();
    }
}
