package lab.lab_6.ex_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void insert_at(ArrayList<String> str_arr, String str, int index) {
        if (index > str_arr.size()) {
            System.err.println("Insertion index out of bounds");
            return;
        }

        str_arr.add(index, str);
    }

    private static void append(ArrayList<String> str_arr, String str) {
        insert_at(str_arr, str, str_arr.size());
    }

    private static int search(ArrayList<String> str_arr, String target) {
        for (int i = 0; i < str_arr.size(); i++)
            if (str_arr.get(i).equals(target))
                return i;

        return -1;
    }

    private static void starts_with(ArrayList<String> str_arr, char start) {
        for (int i = 0; i < str_arr.size(); i++)
            if (str_arr.get(i).charAt(0) == start)
                System.out.println(str_arr.get(i));
    }

    public static void main(String[] args) {
        ArrayList<String> str_arr = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at index");
            System.out.println("2. Append");
            System.out.println("3. Search");
            System.out.println("4. Display strings starting with a character");
            System.out.println("5. Sort");
            System.out.println("6. Display all strings");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter string to insert: ");
                    String insertStr = scanner.nextLine();
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    insert_at(str_arr, insertStr, index);
                    break;
                case 2:
                    System.out.print("Enter string to append: ");
                    String appendStr = scanner.nextLine();
                    append(str_arr, appendStr);
                    break;
                case 3:
                    System.out.print("Enter string to search: ");
                    String searchStr = scanner.nextLine();
                    int foundIndex = search(str_arr, searchStr);
                    if (foundIndex != -1) {
                        System.out.println("String found at index: " + foundIndex);
                    } else {
                        System.out.println("String not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter starting character: ");
                    char startChar = scanner.nextLine().charAt(0);
                    System.out.println("Strings starting with '" + startChar + "':");
                    starts_with(str_arr, startChar);
                    break;
                case 5:
                    System.out.println("Before sorting: " + str_arr);
                    str_arr.sort(null);
                    System.out.println(str_arr);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}