package com.codegym.io_text_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFileExample {
    public static void main(String[] args) throws IOException {
        String fileLocation = "F:\\codegym\\module-02-advanced-programming-with-java\\sources"
                            + "\\lesson-16-17-io-file-handling\\src\\com\\codegym\\file_data\\";
        String fileName = "EmployeeData.txt";
        String filePath = fileLocation.concat(fileName);

        File myFile = new File(filePath);
        if (myFile.exists()) {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] stringParts = line.split(",");
                System.out.printf("ID: %s | Name: %s | Position: %s | Salary: %s%n",
                        stringParts[0], stringParts[1], stringParts[2], stringParts[3]);
            }

            bufferedReader.close();
        } else {
            System.out.println("File not found!");
        }
        
    }
}
