package lab.lab_3.ex_2;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * A Java program to calculate and display a loan amortization schedule.
 * The program takes the loan amount, number of years, and annual interest rate
 * as input and then prints a month-by-month breakdown of payments.
 */
public class MonthlyPayment {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.print("Enter the loan amount: ");
        double loanAmount = input.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = input.nextInt();

        System.out.print("Enter the annual interest rate: ");
        double annualRate = input.nextDouble();

        input.close();

        double monthlyRate = (annualRate / 100) / 12;
        int numberOfMonths = years * 12;

        // Calculate the fixed monthly payment using the amortization formula:
        // M = P [ r(1+r)^n ] / [ (1+r)^n – 1 ]
        // where P = principal, r = monthly rate, n = number of months
        double monthlyPayment;
        if (monthlyRate == 0) {
            monthlyPayment = loanAmount / numberOfMonths;
        } else {
            double powerTerm = Math.pow(1 + monthlyRate, numberOfMonths);
            monthlyPayment = loanAmount * (monthlyRate * powerTerm) / (powerTerm - 1);
        }

        System.out.println("\nYour monthly payment is: " + df.format(monthlyPayment));
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Month | Starting Balance | Monthly Payment | Interest Paid | Principal Paid | Ending Balance");
        System.out.println("------------------------------------------------------------------------------------------------");

        double currentBalance = loanAmount;
        double totalInterestPaid = 0;
        double totalPrincipalPaid = 0;

        for (int month = 1; month <= numberOfMonths; month++) {
            double interestPaid = currentBalance * monthlyRate;
            double principalPaid = monthlyPayment - interestPaid;

            totalInterestPaid += interestPaid;
            totalPrincipalPaid += principalPaid;
            
            if (month == numberOfMonths) {
                principalPaid = currentBalance;
                monthlyPayment = currentBalance + interestPaid;
                currentBalance = 0;
            } else {
                currentBalance -= principalPaid;
            }

            System.out.printf("%5d | %16s | %15s | %13s | %14s | %14s\n",
                    month,
                    "" + df.format(loanAmount - totalPrincipalPaid + principalPaid),
                    "" + df.format(monthlyPayment),
                    "" + df.format(interestPaid),
                    "" + df.format(principalPaid),
                    "" + df.format(currentBalance)
            );
        }

        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("\nTotal Interest Paid over the life of the loan: " + df.format(totalInterestPaid));
        System.out.println("Total Principal Paid: " + df.format(totalPrincipalPaid));
        System.out.println("Calculated Total Payments: " + df.format(monthlyPayment * numberOfMonths));

    }
}