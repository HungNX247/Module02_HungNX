package com.codegym.practice.io_binary_file.copyfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Main1 {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.printf("Enter source file: ");
        String sourcePath = sc.nextLine();
        System.out.printf("Enter destination file: ");
        String desPath = sc.nextLine();

        File soure = new File(sourcePath);
        File des = new File(desPath);

        try {
            copyFileUsing(des, soure);

        } catch (IOException e) {
            System.out.print("Can't copy that file!");
            System.out.printf(e.getMessage());
        }

    }

    private static void copyFileUsing(File des, File soure) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(soure);
            os = new FileOutputStream(des);
            byte[] buffer = new byte[1024];
            int length;

            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

        } finally {
            is.close();
            os.close();
        }
    }
}
