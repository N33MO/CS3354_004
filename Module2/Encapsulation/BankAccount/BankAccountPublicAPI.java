package Module2.Encapsulation.BankAccount;

/**
 * A bank account has a balance that can be changed by
 * deposits and withdrawals.
 */
public class BankAccountPublicAPI {

    /**
     * Constructs a bank account with a zero balance.
     */
    public BankAccountPublicAPI() {
    }

    /**
     * Constructs a bank account with a given balance.
     *
     * @param initialBalance the initial balance
     */
    public BankAccountPublicAPI(double initialBalance) {
    }

    /**
     * Deposits money into this account.
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
    }

    /**
     * Makes a withdrawal from this account, or charges a penalty if
     * sufficient funds are not available.
     *
     * @param amount the amount of the withdrawal
     */
    public void withdraw(double amount) {
    }

    /**
     * Adds interest to this account.
     *
     * @param rate the interest rate in percent
     */
    public void addInterest(double rate) {
    }

    /**
     * Gets the current balance of this account.
     *
     * @return the current balance
     */
    public double getBalance() {
        return 0;
    }
}
