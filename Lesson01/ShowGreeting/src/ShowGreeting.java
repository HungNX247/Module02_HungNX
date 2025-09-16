import java.util.Scanner;

public class ShowGreeting {
    public static void main(String[] args) {
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        scanner.close();

    }
}
