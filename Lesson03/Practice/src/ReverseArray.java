import java.util.Scanner;

public class ReverseArray {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int size;
        int[] array;

        do {
            System.out.println("Enter a size of array: ");
            size = sc.nextInt();
            if (size > 20) {
                System.out.println("Size should not exceed 20");
            }
        } while (size > 20);

        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter element " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }
        System.out.println("Elements in array: ");

        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j] + "\t");
        }

        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.println("Elements in array after reverse: ");
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j] + "\t");
        }

        sc.close();
    }
}
