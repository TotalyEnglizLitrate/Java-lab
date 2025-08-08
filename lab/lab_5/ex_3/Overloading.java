package lab.lab_5.ex_3;

import java.util.Scanner;

public class Overloading {
    private static int add(int x, int y) {
        return x + y;
    }

    private static int add(int x, int y, int z) {
        return add(x, y) + z;
    }
    public static void main(String[] args) {
        Scanner con_in = new Scanner(System.in);
        int x, y, z;

        System.out.print("Enter x: ");
        x = con_in.nextInt();

        System.out.print("Enter y: ");
        y = con_in.nextInt();

        System.out.print("Enter z: ");
        z = con_in.nextInt();

        con_in.close();


        System.out.println("x + y = " + add(x, y));
        System.out.println("y + z = " + add(y, z));
        System.out.println("x + y + z = " + add(x, y, z));

    }
}
