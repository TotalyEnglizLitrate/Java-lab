package lab.lab_8.ex_1;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static void stat(File file) throws IOException {
        boolean read = file.canRead();
        boolean exec = file.canExecute();
        boolean write = file.canWrite();
        boolean is_file = file.isFile();
        long length = file.length();

        if (!file.exists()) {
            System.out.println("File not found!");
            System.exit(0);
        }

        System.out.println((is_file ? "File: ": "Directory: ") + file.getCanonicalPath());
        System.out.println("Length: " + length);
        System.out.println("Read: " + (read ? "yes" : "no"));
        System.out.println("Write: " + (write ? "yes" : "no"));
        System.out.println("Execute: " + (exec ? "yes" : "no"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        File file;
        try {
            file = new File(scanner.next());
            scanner.close();
        } catch (NoSuchElementException e) {
            System.err.println("Please enter a valid filename!");
            return;
        } catch (Exception e) {
            System.err.println("Error reading input!");
            return;
        }

        try {
            stat(file);
        } catch (IOException e) {
            System.err.println("Error stat-ing file!");
        }

        BufferedReader file_reader;
        try {
            file_reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            // unreachable as stat exits on file not found
            return;
        }
        
        String file_content = "";
        try {
            while (file_reader.ready()) {
                file_content += file_reader.readLine() + "\n";
            }
            file_reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file!");
            return;
        }
        
        file_content = file_content.replaceAll("\\s+", "");

        BufferedWriter file_writer;
        try {
            file_writer = new BufferedWriter(new FileWriter(file.toString() + ".out"));
            file_writer.write(file_content);
            file_writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to file!");
        }
    }
}
