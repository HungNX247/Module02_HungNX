import java.util.Scanner;

public class CoutStudentPass {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int size;
        int[] scores;
        do {
            System.out.print("Enter the size of the array (0 < size <= 30): ");
            size = sc.nextInt();
            if (size > 30 || size <= 0) {
                System.out.println("Invalid size, please enter again.");
            }
        } while (size > 30 || size <= 0);
        scores = new int[size];
        for (int i = 0; i < scores.length; i++) {
            do {
                System.out.println("Enter score " + (i + 1) + " (0 <= score <= 10): ");
                scores[i] = sc.nextInt();
                if (scores[i] < 0 || scores[i] > 10) {
                    System.out.println("Invalid score, please enter again.");
                }
            } while (scores[i] < 0 || scores[i] > 10);
        }
        int countPass = 0;
        System.out.println("Array elements are: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
            if (scores[i] >= 5) {
                countPass++;
            }
        }
        System.out.println();

        System.out.println("Number of students passing the exam: " + countPass);

        sc.close();
    }
}
