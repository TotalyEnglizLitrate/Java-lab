package lab.lab_1;

import java.util.Scanner;

public class Factorial {
    private Long getNum(Scanner console) {
        Long num = -1L;
        while (num < 0) {
            System.out.print("Enter number for which you want factorial: ");
            if (console.hasNextLong()) {
                num = console.nextLong();
                if (num < 0) {
                    System.out.println("Invalid input! please try again");
                }
            } else {
                System.out.println("Invalid input! please try again");
                console.next();
            }
        }
        return num;
    }

    private Long factorial(Long n) {
        Long result = 1L;
        for (Long i = 2L; i <= n; i++) {
            result *= i;
            if (result <= 0) {
                return 0L;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Factorial fact = new Factorial();
        Scanner console = new Scanner(System.in);

        Long num = fact.getNum(console);
        console.close();
        
        Long num_fact = fact.factorial(num);
        if (num_fact == 0) {
            System.out.println("Factorial too large to represent");
        } else {
            System.out.printf("%d! = %d\n", num, num_fact);
        }
    }
}
