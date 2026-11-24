package module6.bank;

/**
 * A small example class for teaching unit testing.
 *
 * This class demonstrates:
 * - a constructor that stores account information
 * - a method that returns text: getOwner()
 * - a method that returns a value: getBalance()
 * - methods that change object state: deposit() and withdraw()
 * - invalid input handling with exceptions
 */
public class BankAccount {
    private final String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        if (owner == null || owner.isBlank()) {
            throw new IllegalArgumentException("Owner name cannot be null or blank.");
        }

        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }

        this.owner = owner;
        balance = initialBalance;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0.");
        }

        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Cannot withdraw more than the current balance.");
        }

        balance -= amount;
    }
}
