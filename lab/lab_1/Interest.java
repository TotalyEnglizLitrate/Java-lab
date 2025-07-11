package lab.lab_1;

import java.util.Scanner;

public class Interest {
    private Float getPrincipal(Scanner console) {
        Float principal = -1.0f;
        while (principal <= 0.0) {
            System.out.print("Enter principal amount: ");
            if (console.hasNextFloat()) {
                principal = console.nextFloat();
                if (principal <= 0.0) {
                    System.out.println("Invalid input! please try again");
                }
            } else {
                System.out.println("Invalid input! please try again");
                console.next(); // Clear invalid input
            }
        }
        return principal;
    }

    private Float getInterest(Scanner console) {
        Float interest = -1.0f;
        while (interest < 0.0 || interest > 100.0) {
            System.out.print("Enter interest rate: ");
            if (console.hasNextFloat()) {
                interest = console.nextFloat();
                if (interest < 0.0 || interest > 100.0) {
                    System.out.println("Invalid Input! please try again");
                }
            } else {
                System.out.println("Invalid input! please try again");
                console.next(); // Clear invalid input
            }
        }
        return interest;
    }

    private Float getTime(Scanner console) {
        Integer time = -1;
        while (time <= 0) {
            System.out.print("Enter time (in months): ");
            if (console.hasNextInt()) {
                time = console.nextInt();
                if (time <= 0) {
                    System.out.println("Invalid Input! please try again");
                }
            } else {
                System.out.println("Invalid input! please try again");
                console.next(); // Clear invalid input
            }
        }
        return ((float) time) / 12;
    }

    public static void main(String[] args) {
        Interest si_calc = new Interest();
        Scanner console = new Scanner(System.in);

        Float principal = si_calc.getPrincipal(console);
        Float interest = si_calc.getInterest(console);
        Float time = si_calc.getTime(console);

        console.close();

        Float total_interest = principal * interest * time / 100;

        System.out.print("Total Interest: ");
        System.out.printf("%.2f\n", total_interest);

        System.out.print("Total Amount (Principal + Interest): ");
        System.out.printf("%.2f\n", total_interest + principal);
    }
}
