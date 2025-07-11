package lab.lab_1;

import java.util.Scanner;

public class Factorial {
    private Long getNum(Scanner console) {
        System.out.print("Enter number for which you want factorial: ");

        while(!console.hasNextLong()) {
            System.out.println("Invalid input! please try again");
            System.out.print("Enter number for which you want factorial: ");
        }

        Long num = console.nextLong();

        if (num < 0) {
            System.out.println("Invalid input! please try again");
            return this.getNum(console);
        }

        return num;
    }

    private Long factorial(Long n) {
        if (n == 0 || n == 1) {
            return (long)1;
        }

        return this.factorial(n - 1);

    }
    public static void main(String[] args) {
        Factorial fact = new Factorial();
        Scanner console = new Scanner(System.in);

        Long num = fact.getNum(console);
        console.close();
        
        Long num_fact = fact.factorial(num);

        System.out.printf("%d! = %d", num, num_fact);
    }
}
