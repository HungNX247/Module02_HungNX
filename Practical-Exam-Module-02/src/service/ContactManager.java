package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.Contact;
import util.TextUtils;

public class ContactManager implements IContactManager {

    private List<Contact> contacts = new ArrayList<>();
    private static final String FILE_PATH = "D:/Module02_HungNX/Practical-Exam-Module-02/data/contacts.csv";
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        int count = 0;
        for (Contact contact : contacts) {
            System.out.println(contact);
            count++;
            if (count % 5 == 0) {
                System.out.print("Press Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    @Override
    public void addContact() {
        String phone = inputPhone();

        System.out.print("Enter group: ");
        String group = scanner.nextLine().trim();

        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine().trim();

        System.out.print("Enter gender: ");
        String gender = scanner.nextLine().trim();

        System.out.print("Enter address: ");
        String address = scanner.nextLine().trim();

        String birthday = inputBirthday();
        String email = inputEmail();

        Contact newContact = new Contact(phone, group, fullName, gender, address, birthday, email);
        contacts.add(newContact);

        saveToFile();
        System.out.println("Contact added successfully.");
    }

    @Override
    public void updateContact() {
        System.out.print("Enter phone number of the contact to update: ");
        String phone = scanner.nextLine().trim();

        Contact contact = findByPhone(phone);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.print("Enter new name (Enter to skip): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty())
            contact.setFullName(newName);

        System.out.print("Enter new group (Enter to skip): ");
        String newGroup = scanner.nextLine().trim();
        if (!newGroup.isEmpty())
            contact.setGroup(newGroup);

        System.out.print("Enter new gender (Enter to skip): ");
        String newGender = scanner.nextLine().trim();
        if (!newGender.isEmpty())
            contact.setGender(newGender);

        System.out.print("Enter new address (Enter to skip): ");
        String newAddress = scanner.nextLine().trim();
        if (!newAddress.isEmpty())
            contact.setAddress(newAddress);

        System.out.print("Enter new birthday (Enter to skip): ");
        String newBirthday = scanner.nextLine().trim();
        if (!newBirthday.isEmpty()) {
            newBirthday = inputBirthday();
            contact.setBirthday(newBirthday);
        }

        System.out.print("Enter new email (Enter to skip): ");
        String newEmail = scanner.nextLine().trim();
        if (!newEmail.isEmpty()) {
            while (!isValidEmail(newEmail)) {
                System.out.print("Invalid email. Enter again: ");
                newEmail = scanner.nextLine().trim();
            }
            contact.setEmail(newEmail);
        }

        saveToFile();
        System.out.println("Contact updated successfully.");
    }

    @Override
    public void deleteContact() {
        System.out.print("Enter phone number of the contact to delete: ");
        String phone = scanner.nextLine().trim();

        Contact contact = findByPhone(phone);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.print("Are you sure you want to delete this contact? (Y/N): ");
        if (!scanner.nextLine().trim().equalsIgnoreCase("Y")) {
            System.out.println("Deletion cancelled.");
            return;
        }

        contacts.remove(contact);
        saveToFile();
        System.out.println("Contact deleted successfully.");
    }

    @Override
    public void search() {
        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        String keywordNoAccent = TextUtils.removeAccent(keyword).toLowerCase();

        boolean found = false;

        for (Contact contact : contacts) {
            String nameNoAccent = TextUtils.removeAccent(contact.getFullName()).toLowerCase();

            if (contact.getPhoneNumber().contains(keyword)
                    || nameNoAccent.contains(keywordNoAccent)) {

                System.out.println(contact);
                found = true;
            }
        }

        if (!found)
            System.out.println("No contacts found.");
    }

    @Override
    public void loadFromFile() {
        contacts.clear();
        File file = new File(FILE_PATH);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
                return;
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length == 7) {
                    contacts.add(new Contact(p[0], p[1], p[2], p[3], p[4], p[5], p[6]));
                }
            }

            System.out.println("Contacts loaded successfully.");

        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    @Override
    public void saveToFile() {
        File file = new File(FILE_PATH);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
                return;
            }
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_PATH))) {

            for (Contact c : contacts) {
                pw.println(c.toCsv());
            }

            System.out.println("Auto-saved to file.");

        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private String inputEmail() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();

        while (!isValidEmail(email)) {
            System.out.print("Invalid email format. Enter again: ");
            email = scanner.nextLine().trim();
        }
        return email;
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$");
    }

    private String inputPhone() {
        System.out.print("Enter phone number (10–11 digits): ");
        String phone = scanner.nextLine();

        while (!phone.matches("^0\\d{9,10}$")) {
            System.out.print("Invalid phone. Enter again: ");
            phone = scanner.nextLine();
        }
        return phone;
    }

    private Contact findByPhone(String phone) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phone))
                return contact;
        }
        return null;
    }

    private String inputBirthday() {
        while (true) {
            System.out.print("Enter birthday (dd/MM/yyyy): ");
            String input = scanner.nextLine().trim();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            try {
                LocalDate date = LocalDate.parse(input, formatter);

                if (date.isAfter(LocalDate.now())) {
                    System.out.println("Birthday cannot be in the future.");
                    continue;
                }

                return input;

            } catch (Exception e) {
                System.out.println("Invalid date. Try again.");
            }
        }
    }

}
