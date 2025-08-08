package lab.lab_5.ex_1;

import java.util.Scanner;

class Shape {
    protected int x;
    protected int y;
    void print_area() {}

    Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Shape() {}

}

class Rectangle extends Shape {
    Rectangle(Scanner con_in) {
        System.out.print("Enter length of rectangle: ");
        this.x = con_in.nextInt();
        System.out.print("Enter breadth of rectangle: ");
        this.y = con_in.nextInt();
    }

    void print_area() {
        System.out.println("Area of rectangle with sides " + x + " and " + y + " = " + x * y);
    }
}

class Triangle extends Shape {
    Triangle(Scanner con_in) {
        System.out.print("Enter base length of triangle: ");
        this.x = con_in.nextInt();
        System.out.print("Enter height of triangle: ");
        this.y = con_in.nextInt();
    }

    void print_area() {
        System.out.println("Area of triangle with base " + x + " and height " + y + " = " + 0.5 * (float)(x * y));
    }
}


class Circle extends Shape {
    private static final float PI = 3.14159f;

    Circle(int x, int y) {
        super(x, 0);
    }
    Circle(Scanner con_in) {
        System.out.print("Enter radius of circle: ");
        this.x = con_in.nextInt();
    }

    void print_area() {
        System.out.println("Area of circle with radius " + x + " = " + PI * (float)(x * x));
    }
}



public class Main {
    public static void main(String[] args) {
        Scanner con_in = new Scanner(System.in);
        Shape rect, triangle, circle;
        
        rect = new Rectangle(con_in);
        rect.print_area();

        System.out.println();

        triangle = new Triangle(con_in);
        triangle.print_area();

        System.out.println();
        
        circle = new Circle(con_in);
        circle.print_area();

        con_in.close();
    }
}