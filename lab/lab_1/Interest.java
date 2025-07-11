package lab.lab_1;

import java.util.Scanner;

public class Interest {
    private Float getPrincipal(Scanner console) {
        System.out.print("Enter principal amount: ");
        
        while (!console.hasNextFloat()) {
            System.out.println("Invalid input! please try again");
            System.out.print("Enter principal amount: ");
        }

        return console.nextFloat();
    }

    public Float getInterest(Scanner console) {
        System.out.print("Enter interest rate: ");

        while(!console.hasNextFloat()) {
            System.out.println("Invalid input! please try again");
            System.out.print("Enter interest rate: ");
        }

        Float interest = console.nextFloat();

        if (interest > 100.0 || interest < 0.0) {
            System.out.println("Invalid Input! please try again");
            this.getInterest(console);
        }

        return interest;
    }

    public Float getTime(Scanner console) {
        System.out.print("Enter time (in months): ");

        while(!console.hasNextInt()) {
            System.out.println("Invalid input! please try again");
            System.out.print("Enter time (in months): ");
        }

        return ((float) console.nextInt()) / 12;
    }

    public static void main(String[] args) {
        Interest si_calc = new Interest();
        Scanner console = new Scanner(System.in);

        Float principal = si_calc.getPrincipal(console);
        Float interest = si_calc.getInterest(console);
        Float time = si_calc.getTime(console);

        console.close();

        Float total_interest = principal * interest * time;

        System.out.print("Total Interest: ");
        System.out.printf("%.2f\n", total_interest);

        System.out.print("Total Amount (Principal + Interest): ");
        System.out.printf("%.2f\n", total_interest + principal);
    }
}
