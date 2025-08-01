package lab.lab_3.ex_1;

import java.util.Scanner;

public class Employee {
    public String employee_name;
    public int employee_id;
    public String address;
    public String email;
    public String mobile_no;
    public float base_pay;
    public float gross_salary;
    public float net_salary;

    public float da;
    public float hra;
    public float pf;
    public float staff_club;

    private static float DA_RATE = .97f;
    private static float HRA_RATE = .1f;
    private static float PF_RATE = .12f;
    private static float STAFF_CLUB_RATE = .001f;

    Employee(String employee_name, int employee_id, String address, String email, String mobile_no, float base_pay) {
        this.employee_name = employee_name;
        this.employee_id = employee_id;
        this.address = address;
        this.email = email;
        this.mobile_no = mobile_no;
        this.base_pay = base_pay;

        this.da = base_pay * DA_RATE;
        this.hra = base_pay * HRA_RATE;
        this.pf = base_pay * PF_RATE;
        this.staff_club = base_pay * STAFF_CLUB_RATE;

        this.gross_salary = base_pay + this.da + this.hra;
        this.net_salary = this.gross_salary - (this.pf + this.staff_club);
    }


    Employee() {}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        while (!(1 <= choice && choice <= 4)) {
            System.out.println("1. Programmer\n2. Assistant Professor\n3. Associate Professor\n4. Professor");
            System.out.print("Enter choice: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (!(1 <= choice && choice <= 4)) {
                    System.out.println("Invalid choice!");
                }
            } else {
                System.out.println("Invalid choice!");
                sc.next();
            }
        }


        System.out.println();
        System.out.print("Enter Employee ID: ");
        int employee_id = sc.nextInt();
        System.out.print("Enter Employee Name: ");
        sc.skip("\n");
        String employee_name = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Mail ID: ");
        String email = sc.nextLine();
        System.out.print("Enter Mobile No: ");
        String mobile_no = sc.nextLine();
        System.out.print("Enter Base pay: ");
        float base_pay = sc.nextFloat();
        sc.close();

        PaySlip payslip = new PaySlip();

        switch (choice) {
            case 1:
                Programmer p = new Programmer(employee_name, employee_id, address, email, mobile_no, base_pay);
                payslip.print_payslip(p);
                break;
            case 2:
                AssistantProf ap = new AssistantProf(employee_name, employee_id, address, email, mobile_no, base_pay);
                payslip.print_payslip(ap);
                break;
            case 3:
                AssociateProf asp = new AssociateProf(employee_name, employee_id, address, email, mobile_no, base_pay);
                payslip.print_payslip(asp);
                break;
            case 4:
                Professor prof = new Professor(employee_name, employee_id, address, email, mobile_no, base_pay);
                payslip.print_payslip(prof);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}