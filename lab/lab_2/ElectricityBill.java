/*
 * Time of Creation: Fri 18 Jul 2025 9:20:27 AM IST
 * OpenJDK version: 11.0.27 2025-04-15
 */

package lab.lab_2;

import java.util.Scanner;

public class ElectricityBill {
    // Enumeration for type of connection
    private enum ConnectionType {
        DOMESTIC,
        COMMERCIAL,
        UNDEFINED
    }
    
    // Hardcoded rates and their corresponding thresholds
    private static Float[] domestic_rates = {1f, 2.5f, 4f, 6f};
    private static Float[] commercial_rates = {2f, 4.5f, 6f, 7f};
    private static int[] thresholds = {0, 101, 201, 501, Integer.MAX_VALUE};
    
    // Class attributes
    private int consumer_num;
    private String consumer_name;
    private Float prev_reading;
    private Float current_reading;
    private Float units_consumed;
    private ConnectionType conn_type;
    private Float bill_amt;

    // Constructor
    private ElectricityBill(int consumer_num, String consumer_name, Float prev_reading, Float current_reading, ConnectionType conn_type) {
        this.consumer_num = consumer_num;
        this.consumer_name = consumer_name;
        this.prev_reading = prev_reading;
        this.current_reading = current_reading;
        this.units_consumed = current_reading - prev_reading; // Calculate units consumed
        this.conn_type = conn_type;
        this.bill_amt = Float.NaN; // Set bill amount to NaN to indicate calculation is pending
    }

    // Helper function to calculate the bill
    private void bill() {

        // Identify which slab the no. of units consumed lies in
        int idx;
        for (idx = 0; idx < thresholds.length - 1; idx++)
            if (this.units_consumed > thresholds[idx] && this.units_consumed < thresholds[idx + 1]) break;

        switch (conn_type) {
            case DOMESTIC:
                this.bill_amt = this.units_consumed * domestic_rates[idx];
                break;
        
            case COMMERCIAL:
                this.bill_amt = this.units_consumed * commercial_rates[idx];
                break;

            // UNDEFINED and default should be unreachable under normal circumstances
            case UNDEFINED:
                break;

            default:
                break;
        }
    }

    // Helper function to print bill details
    private void print_bill() {
        if (this.bill_amt.isNaN()) this.bill(); // if called before the bill is calculated, calculate it before proceeding

        System.out.println("\n\n");
        System.out.println("Consumer no.     : " + this.consumer_num);
        System.out.println("Consumer name    : " + this.consumer_name);
        System.out.println("Connection type  : " + this.conn_type);
        System.out.println("Previous reading : " + this.prev_reading);
        System.out.println("Current reading  : " + this.current_reading);
        System.out.println("Units Consumed   : " + this.units_consumed);
        System.out.println("Bill due         : " + this.bill_amt);
    }

    public static void main(String[] args) {
        Scanner in_stream = new Scanner(System.in);
        
        System.out.print("Enter the Consumer Name: ");
        String consumer_name = in_stream.nextLine();

        // General input bounds checking for all input provided
        int consumer_num = -1;
        while (consumer_num < 0) {
            System.out.print("Enter the Consumer Number: ");
            if (in_stream.hasNextInt()) {
                consumer_num = in_stream.nextInt();
                if (consumer_num < 0) System.out.println("Consumer number must be positive!");
            } else {
                System.out.println("Invalid number!");
                in_stream.next();
            }
        }

        
        Float prev_reading = -1f;
        while (prev_reading < 0f || prev_reading.isNaN() || prev_reading.isInfinite()) {
            System.out.print("Enter previous month reading: ");
            if (in_stream.hasNextFloat()) {
                prev_reading = in_stream.nextFloat();
                if (prev_reading < 0f || prev_reading.isNaN() || prev_reading.isInfinite())
                    System.out.println("Reading must be positive!");
            } else {
                System.out.println("Invalid reading!");
                in_stream.next();
            }
        }

        Float current_reading = -1f;
        while (current_reading < prev_reading || current_reading.isNaN() || current_reading.isInfinite()) {
            System.out.print("Enter current month reading: ");
            if (in_stream.hasNextFloat()) {
                current_reading = in_stream.nextFloat();
                if (current_reading < prev_reading || current_reading.isNaN() || current_reading.isInfinite())
                    System.out.println("Reading must be greater than last months'!");
            } else {
                System.out.println("Invalid reading!");
                in_stream.next();
            }
        }

        ConnectionType conn_type = ConnectionType.UNDEFINED;
        int _conn_type;

        while (conn_type == ConnectionType.UNDEFINED) {
            System.out.println("Enter connection type:");
            System.out.println("1 - Domestic\n2 - Commercial\n");
            if (in_stream.hasNextInt()) {
                _conn_type = in_stream.nextInt();
                if (_conn_type == 1) conn_type = ConnectionType.DOMESTIC;
                else if (_conn_type == 2) conn_type = ConnectionType.COMMERCIAL;
                else System.out.println("Invalid connection type!");
            }
        } // conn_type should never be UNDEFINED, this loop ensures that

        in_stream.close();

        ElectricityBill new_bill = new ElectricityBill(consumer_num, consumer_name, prev_reading, current_reading, conn_type);
        new_bill.bill();
        new_bill.print_bill();
    }
}