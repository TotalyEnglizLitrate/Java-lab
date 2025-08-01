package lab.lab_3.ex_1;

public class PaySlip {
    public void print_payslip(Employee emp) {
        System.out.print("Employee name          : ");
        System.out.println(emp.employee_name);
        System.out.print("Employee ID            : ");
        System.out.println(emp.employee_id);
        System.out.print("Address                : ");
        System.out.println(emp.address);
        System.out.print("Email                  : ");
        System.out.println(emp.email);
        System.out.print("Mobile no:             : ");
        System.out.println();
        System.out.println(emp.mobile_no);
        System.out.print("Basic pay              : ");
        System.out.println(emp.base_pay);
        System.out.print("DA (97%)               : ");
        System.out.println(emp.da);
        System.out.print("HRA (10%)              : ");
        System.out.println(emp.hra);
        System.out.print("PF (12%)               : ");
        System.out.println(emp.pf);
        System.out.print("Staff club fund (0.1%) : ");
        System.out.println(emp.staff_club);
        System.out.println();
        System.out.print("Gross salary           : ");
        System.out.println(emp.gross_salary);
        System.out.print("Net salary             : ");
        System.out.println(emp.net_salary);
    }
}
