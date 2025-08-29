package lab.lab_7.ex_1;

class InsufficientBalance extends RuntimeException {
    InsufficientBalance(double bal) {
        super(String.format("Balance of %.2f is lesser than minimum balance of Rs. 1000", bal));
    }
}

public class Main {
    private static void check_balance(double bal) throws InsufficientBalance {
        if (bal < 1000.) {
            throw new InsufficientBalance(bal);
        }
    }

    public static void main(String[] args) {
        double[] balances = {1500., 800., 2500., 1200., 3000., 950., 10000.};

        for (double bal : balances) {
            try {
                check_balance(bal);
            } catch (InsufficientBalance e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("Account balance is sufficient: " + bal);
        }
    }
}
