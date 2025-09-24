import java.util.Scanner;

public class MergeArrays {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int size1, size2;
        int[] array1, array2;
        System.out.print("Enter the size of the first array: ");
        size1 = sc.nextInt();
        array1 = new int[size1];
        for (int i = 0; i < array1.length; i++) {
            System.out.println("Enter number " + (i + 1) + " of the first array: ");
            array1[i] = sc.nextInt();
        }
        System.out.print("Enter the size of the second array: ");
        size2 = sc.nextInt();
        array2 = new int[size2];
        for (int i = 0; i < array2.length; i++) {
            System.out.println("Enter number " + (i + 1) + " of the second array: ");
            array2[i] = sc.nextInt();
        }
        int[] mergeArrays = new int[array1.length + array2.length];
        for (int i = 0; i < mergeArrays.length; i++) {
            if (i < array1.length) {
                mergeArrays[i] = array1[i];
            } else {
                mergeArrays[i] = array2[i - array1.length];
            }
        }
        System.out.println("The merged array is: ");
        for (int i = 0; i < mergeArrays.length; i++) {
            System.out.print(mergeArrays[i] + " ");
        }
        sc.close();
    }
}
