package lab.lab_7.ex_2;

public class User {
    protected int id;
    protected float balance;

    public class InsufficientBalance extends RuntimeException {
        public InsufficientBalance(User user) {
            super(String.format("Insufficient funds in account of user with id: %d (%.2f)", user.get_id(), user.get_bal()));
        }
    }

    public User(int id, float balance) throws InsufficientBalance {
        this.id = id;
        this.set_bal(balance);
    }

    public int get_id() {
        return this.id;
    }

    public float get_bal() {
        return this.balance;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public void set_bal(float balance) throws InsufficientBalance {
        this.balance = balance;
        if (balance < 1000.) {
            throw new InsufficientBalance(this);
        }
    }

    public String toString() {
        return String.format("User{id: %d, balance: %.2f}", this.id, this.balance);
    }
}
