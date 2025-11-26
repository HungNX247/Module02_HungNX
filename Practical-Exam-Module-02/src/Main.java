import java.util.Scanner;

import service.ContactManager;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ContactManager manager = new ContactManager();

        while (true) {
            System.out.println("\n--- Contact Management ---");
            System.out.println("1. Display Contacts");
            System.out.println("2. Add Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Search Contacts");
            System.out.println("6. Load Contacts from File");
            System.out.println("7. Save Contacts to File");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    manager.displayContacts();
                    break;
                case 2:
                    manager.addContact();
                    break;
                case 3:
                    manager.updateContact();
                    break;
                case 4:
                    manager.deleteContact();
                    break;
                case 5:
                    manager.search();
                    break;
                case 6:
                    manager.loadFromFile();
                    break;
                case 7:
                    manager.saveToFile();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}
