/*
 * @author: Tamer Zreg
 * @version: 1.0
 * @since: 2024-04-23
 */
package com.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReverseString {
    public static void main(String[] args) {
        // File paths
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";
        try {
            // Read the content of the file
            String str = readFileAsString(inputFileName);
            // Reverse the string
            String reversed = reverseString(str);
            // Print the original and reversed strings
            System.out.println("Original string: " + str);
            System.out.println("Reversed string: " + reversed);
            // Write original and reversed strings to output file
            writeToFile(outputFileName, "Original string: " + str + "\nReversed string: " + reversed);
            System.out.println("Output written to " + outputFileName);
        } catch (IOException e) {
            // Handle IO exceptions
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Function to read the content of a file and return it as a string
    public static String readFileAsString(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Read each line from the file and append it to the StringBuilder
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        // Return the content of the file as a string
        return content.toString();
    }

    // Function to reverse a string recursively
    public static String reverseString(String str) {
        // Base case: if the string is empty, return it
        if (str.isEmpty()) {
            return str;
        }
        // Recursive case: reverse the substring starting from the second character and append the first character
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    // Function to write content to a file
    public static void writeToFile(String fileName, String content) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        }
    }
}
