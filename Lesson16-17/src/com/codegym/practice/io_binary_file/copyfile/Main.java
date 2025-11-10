package com.codegym.practice.io_binary_file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter source file: ");
        String sourcePath = sc.nextLine();
        System.out.printf("Enter destination file: ");
        String desPath = sc.nextLine();

        File sourceFile = new File(sourcePath);
        File desFile = new File(desPath);

        try {
            copyFileUsingJava7(sourceFile, desFile);
            System.out.print("Copy compeleted");
        } catch (IOException e) {
            System.out.print("Can't copy that file!");
            System.out.printf(e.getMessage());
        }
        sc.close();
    }

    private static void copyFileUsingJava7(File sourceFile, File desFile) throws IOException {
        Files.copy(sourceFile.toPath(), desFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

}
