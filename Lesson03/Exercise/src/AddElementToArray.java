import java.util.Scanner;

public class AddElementToArray {
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
        System.out.println("Enter value to add: ");
        int valueToAdd = sc.nextInt();
        System.out.println("Enter index to add: ");
        int indexToAdd = sc.nextInt();

        if (indexToAdd < 0 || indexToAdd > numbers.length) {
            System.out.println("Invalid index.");
        } else {
            int[] newArray = new int[numbers.length + 1];
            for (int i = 0, j = 0; i < newArray.length; i++) {
                if (i == indexToAdd) {
                    newArray[i] = valueToAdd;
                } else {
                    newArray[i] = numbers[j++];
                }
            }
            System.out.println("Array after adding " + valueToAdd + " at index " + indexToAdd + ": ");
            for (int i = 0; i < newArray.length; i++) {
                System.out.println(newArray[i] + " ");
            }
        }
        sc.close();
    }
}
