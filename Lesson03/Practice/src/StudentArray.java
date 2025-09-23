import java.util.Scanner;

public class StudentArray {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] students = { "John", "Jane", "Jim", "Jill", "Jack" };
        System.out.print("Enter a name to search: ");
        String input_name = sc.nextLine();

        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input_name)) {
                System.out.println("Name " + input_name + " exists in the array at index " + i + ".");
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            System.out.println("Name " + input_name + " does not exist in the array.");
        }
        sc.close();
    }
}
