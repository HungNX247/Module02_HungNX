package com.codegym.io_text_file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextFileExample {
    public static void main(String[] args) throws IOException {
        String[] employees = {
                "E001,Dao Nguyen,Senior Developer,2500",
                "E002,Minh Tran,DevOps Engineer,2300",
                "E003,Thu Le,UI Designer,1800"
        };

        String fileLocation = "F:\\codegym\\module-02-advanced-programming-with-java\\sources\\lesson-16-17-io-file-handling\\src\\com\\codegym\\file_data\\";
        String fileName = "EmployeeData.txt";
        String filePath = fileLocation.concat(fileName);

        File myFile = new File(filePath);
        if (!myFile.exists()) {
            myFile.createNewFile();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String emp : employees) {
                writer.write(emp);
                writer.newLine();
            }
            System.out.println("File written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
