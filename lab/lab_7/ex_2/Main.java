package lab.lab_7.ex_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter balances file path: ");
        File path = new File(scanner.nextLine());

        scanner.close();
        
        if (!path.isAbsolute())
            path = path.getAbsoluteFile();

        FileReader reader;

        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist! exiting.");
            return;
        }

        Scanner file_scanner = new Scanner(reader);
        ArrayList<User> users = new ArrayList<>();
        int id;
        float balance;

        while (file_scanner.hasNext()) {
            try {
                id = file_scanner.nextInt();
                balance = file_scanner.nextFloat();
                users.add(new User(id, balance));
            } catch (InputMismatchException e) {
                System.err.println("Entry has invalid format; skipping\n");
                file_scanner.nextLine();
                continue;
            } catch (User.InsufficientBalance e) {
                System.err.println(e.getMessage() + "\n");
                continue;
            }
        }
        file_scanner.close();

        System.out.println(users);
    }
}
