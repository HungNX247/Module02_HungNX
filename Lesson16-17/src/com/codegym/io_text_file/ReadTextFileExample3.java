package com.codegym.io_text_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFileExample3 {
    
    public static void main(String[] args) throws IOException {
        String fileLocation = "F:\\codegym\\module-02-advanced-programming-with-java\\sources"
                + "\\lesson-16-17-io-file-handling\\src\\com\\codegym\\file_data\\";
        String fileName = "application.properties";
        String filePath = fileLocation.concat(fileName);
        
        File myFile = new File(filePath);
        if (!myFile.exists()) {
            System.out.println("File not found!");
        } else {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Ignore blank lines or comment lines
                if (line.trim().isEmpty() || line.startsWith("#"))
                    continue;

                // Split only on the first '='
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    System.out.printf("%s = %s%n", key, value);
                } else {
                    System.out.println("Invalid line (no '='): " + line);
                }
            }

            bufferedReader.close();
        }
    }
}
