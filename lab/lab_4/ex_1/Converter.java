package lab.lab_4.ex_1;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Main application class for the unit converter.
 * This class serves as the entry point and provides a menu-driven
 * interface to the user. It imports and utilizes classes from different packages.
 */
public class Converter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##"); // Formats output to two decimal places
        boolean running = true;

        System.out.println("--- Unit Converter Application ---");

        while (running) {
            System.out.println("\nPlease select a converter:");
            System.out.println("1. Currency Converter");
            System.out.println("2. Distance Converter");
            System.out.println("3. Time Converter");
            System.out.println("0. Exit");
            System.out.print("Enter your choice (0-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    handleCurrencyConversion(scanner, df);
                    break;
                case 2:
                    handleDistanceConversion(scanner, df);
                    break;
                case 3:
                    handleTimeConversion(scanner, df);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
        scanner.close();
    }

    private static void handleCurrencyConversion(Scanner scanner, DecimalFormat df) {
        CurrencyConverter currencyConverter = new CurrencyConverter();
        System.out.println("\n--- Currency Converter ---");
        System.out.println("1. USD to INR");
        System.out.println("2. INR to USD");
        System.out.println("3. EUR to INR");
        System.out.println("4. INR to EUR");
        System.out.println("5. JPY to INR");
        System.out.println("6. INR to JPY");
        System.out.print("Enter your choice (1-6): ");
        int currencyChoice = scanner.nextInt();
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        switch (currencyChoice) {
            case 1:
                System.out.println(df.format(amount) + " USD is " + df.format(currencyConverter.usdToInr(amount)) + " INR");
                break;
            case 2:
                System.out.println(df.format(amount) + " INR is " + df.format(currencyConverter.inrToUsd(amount)) + " USD");
                break;
            case 3:
                System.out.println(df.format(amount) + " EUR is " + df.format(currencyConverter.eurToInr(amount)) + " INR");
                break;
            case 4:
                System.out.println(df.format(amount) + " INR is " + df.format(currencyConverter.inrToEur(amount)) + " EUR");
                break;
            case 5:
                System.out.println(df.format(amount) + " JPY is " + df.format(currencyConverter.jpyToInr(amount)) + " INR");
                break;
            case 6:
                System.out.println(df.format(amount) + " INR is " + df.format(currencyConverter.inrToJpy(amount)) + " JPY");
                break;
            default:
                System.out.println("Invalid currency choice.");
        }
    }

    private static void handleDistanceConversion(Scanner scanner, DecimalFormat df) {
        DistanceConverter distanceConverter = new DistanceConverter();
        System.out.println("\n--- Distance Converter ---");
        System.out.println("1. Meters to Kilometers");
        System.out.println("2. Kilometers to Meters");
        System.out.println("3. Miles to Kilometers");
        System.out.println("4. Kilometers to Miles");
        System.out.print("Enter your choice (1-4): ");
        int distChoice = scanner.nextInt();
        System.out.print("Enter the value: ");
        double value = scanner.nextDouble();

        switch (distChoice) {
            case 1:
                System.out.println(df.format(value) + " meters is " + df.format(distanceConverter.metersToKm(value)) + " km");
                break;
            case 2:
                System.out.println(df.format(value) + " km is " + df.format(distanceConverter.kmToMeters(value)) + " meters");
                break;
            case 3:
                System.out.println(df.format(value) + " miles is " + df.format(distanceConverter.milesToKm(value)) + " km");
                break;
            case 4:
                System.out.println(df.format(value) + " km is " + df.format(distanceConverter.kmToMiles(value)) + " miles");
                break;
            default:
                System.out.println("Invalid distance choice.");
        }
    }

    private static void handleTimeConversion(Scanner scanner, DecimalFormat df) {
        TimeConverter timeConverter = new TimeConverter();
        System.out.println("\n--- Time Converter ---");
        System.out.println("1. Hours to Minutes");
        System.out.println("2. Minutes to Hours");
        System.out.println("3. Minutes to Seconds");
        System.out.println("4. Seconds to Minutes");
        System.out.print("Enter your choice (1-4): ");
        int timeChoice = scanner.nextInt();
        System.out.print("Enter the value: ");
        double value = scanner.nextDouble();

        switch (timeChoice) {
            case 1:
                System.out.println(df.format(value) + " hours is " + df.format(timeConverter.hoursToMinutes(value)) + " minutes");
                break;
            case 2:
                System.out.println(df.format(value) + " minutes is " + df.format(timeConverter.minutesToHours(value)) + " hours");
                break;
            case 3:
                System.out.println(df.format(value) + " minutes is " + df.format(timeConverter.minutesToSeconds(value)) + " seconds");
                break;
            case 4:
                System.out.println(df.format(value) + " seconds is " + df.format(timeConverter.secondsToMinutes(value)) + " minutes");
                break;
            default:
                System.out.println("Invalid time choice.");
        }
    }
}