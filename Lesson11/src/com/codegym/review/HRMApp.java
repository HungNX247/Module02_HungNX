package com.codegym.review;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HRMApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Candidate> candidates;

    public static void initData() {
        LocalDate dateOfBirth01 = LocalDate.of(2000, 2, 15);
        LocalDate dateOfBirth02 = LocalDate.of(2000, 10, 15);
        LocalDate dateOfBirth03 = LocalDate.of(2000, 5, 15);

        Candidate candidate01 = new Candidate(1, "Ty Nguyen", dateOfBirth01,
            "123 CMT8", "ty1@gmail.com", "090123456", "Java Developer");
        Candidate candidate02 = new Candidate(2, "Teo Nguyen", dateOfBirth02,
            "456 CMT8", "teo@gmail.com", "090123789", "ReactJS Developer");
        Candidate candidate03 = new Candidate(3, "Ty Le", dateOfBirth03,
                "789 CMT8", "ty2@gmail.com", "090123799", "FullStack Developer");

        candidates = new ArrayList<>();
        candidates.add(candidate01);
        candidates.add(candidate02);
        candidates.add(candidate03);
    }

    public static void main(String[] args) {
        initData();

        System.out.println("Welcome to HRM Application");
        System.out.println("-----------------------------");
        System.out.println("1. Display list of candidates");
        System.out.println("2. Find a candidate by phone or email");
        System.out.println("3. Search candidates by name");
        System.out.println("4. Create a new candidate");
        System.out.println("5. Update an existing candidate");
        System.out.println("6. Remove an existing candidate");
        System.out.println("-----------------------------");
        System.out.print("-> Choose feature or press any key to exit: ");
        int choose = scanner.nextInt();

        if (choose < 0 || choose > 6) {
            System.out.println("Good bye! See you again!");
        } else {
            while (choose > 0 && choose < 7) {
                switch (choose) {
                    case 1:
                        displayCandidates(candidates);
                        break;
                    case 2:
                        String phoneOrEmail = getPhoneOrEmail();

                        Map<Candidate, Integer> existingCandidate = findCandidate(phoneOrEmail);
                        if (existingCandidate != null) {
                            System.out.println(existingCandidate);
                        } else {
                            System.out.println("Candidate not found!");
                        }
                        break;
                    case 3:
                        searchCandidatesByName();
                        break;
                    case 4:
                        createNewCandidate();
                        break;
                    case 5:
                        String currentPhoneOrEmail = getPhoneOrEmail();

                        Map<Candidate, Integer> candidateMap = findCandidate(currentPhoneOrEmail);
                        if (!candidateMap.isEmpty()) {
                            updateExistingCandidate(candidateMap);
                        } else {
                            System.out.println("Candidate not found!");
                        }
                        break;
                    case 6:
                        String deletePhoneOrEmail = getPhoneOrEmail();
                        Map<Candidate, Integer> deleteMap = findCandidate(deletePhoneOrEmail);
                        removeExistingCandidate(deleteMap);
                        break;
                    default:
                        System.out.println("Invalid feature! Please choose again!");
                        break;
                }

                System.out.println("\nHRM Application Features");
                System.out.println("-----------------------------");
                System.out.println("1. Display list of candidates");
                System.out.println("2. Find a candidate by phone or email");
                System.out.println("3. Search candidates by name");
                System.out.println("4. Create a new candidate");
                System.out.println("5. Update an existing candidate");
                System.out.println("6. Remove an existing candidate");
                System.out.println("-----------------------------");
                System.out.print("-> Choose feature or press any key to exit: ");
                choose = scanner.nextInt();

                if (choose < 0 || choose > 6) {
                    System.out.println("Good bye! See you again!");
                }
            }
        }

        scanner.close();
    }

    public static void removeExistingCandidate(Map<Candidate, Integer> candidateMap) {
        if (candidateMap == null || candidateMap.isEmpty()) {
            System.out.println("Candidate not found!");
            return;
        }

        Candidate candidateToRemove = candidateMap.keySet().iterator().next();
        int index = candidateMap.get(candidateToRemove);

        System.out.println("\nCandidate to be removed:");
        System.out.println(candidateToRemove);

        System.out.print("\nAre you sure you want to delete this candidate? (Y/N): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            candidates.remove(index);
            System.out.println("\nCandidate removed successfully!");
            displayCandidates(candidates);
        } else {
            System.out.println("\nDeletion cancelled.");
        }
    }

    private static String getPhoneOrEmail() {
        System.out.print("\nPlease enter phone or email of candidate: ");
        scanner.nextLine();
        String phoneOrEmail = scanner.nextLine();
        return phoneOrEmail;
    }

    public static void updateExistingCandidate(Map<Candidate, Integer> candidateMap) {
        Candidate oldCandidate = candidateMap.keySet().iterator().next();
        int index = candidateMap.get(oldCandidate);

        System.out.println("\nPlease enter updated information:");
        Candidate updatedCandidate = getCandidate();

        candidates.set(index, updatedCandidate);
        System.out.println("\nCandidate updated successfully!");

        displayCandidates(candidates);
    }

    public static void createNewCandidate() {
        System.out.println("To creating a new candidate, please enter info below: ");
        Candidate newCandidate = getCandidate();
        candidates.add(newCandidate);
        displayCandidates(candidates);
    }

    private static Candidate getCandidate() {
        System.out.print("Enter candidate's id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter candidate's full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter candidate's date of birth: ");
        String dobInput = scanner.nextLine();
        LocalDate dob = LocalDate.parse(dobInput);

        System.out.print("Enter candidate's address: ");
        String address = scanner.nextLine();

        System.out.print("Enter candidate's email: ");
        String email = scanner.nextLine();

        System.out.print("Enter candidate's phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter candidate's position: ");
        String position = scanner.nextLine();

        Candidate candidate = new Candidate(id, fullName, dob, address, email, phone, position);
        return candidate;
    }

    public static void searchCandidatesByName() {
        System.out.print("\nPlease enter name of candidate: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        List<Candidate> result = new ArrayList<>();
        for (int i = 0; i < candidates.size(); i++) {
            if (candidates.get(i).getFullName().contains(name)) {
                result.add(candidates.get(i));
            }
        }

        displayCandidates(result);
    }

    public static Map<Candidate, Integer> findCandidate(String phoneOrEmail) {
        Map<Candidate, Integer> result = new HashMap<>();

        for (int i = 0; i < candidates.size(); i++) {
            String phone = candidates.get(i).getPhone();
            String email = candidates.get(i).getEmail();

            if (phoneOrEmail.equals(phone) || phoneOrEmail.equals(email)) {
                result.put(candidates.get(i), i);
                return result;
            }
        }
        return null;
    }

    public static void displayCandidates(List<Candidate> candidates) {
        System.out.println("\nList of candidates: ");
        for (int i=0; i < candidates.size(); i++) {
            System.out.println(candidates.get(i));
        }
    }
}
