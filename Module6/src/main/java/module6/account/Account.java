package module6.account;

public class Account {
    private int balanceAmount;

    public Account() {
        balanceAmount = 0;
    }

    public Account transact(int amount) {
        if (amount > 0) {
            balanceAmount += amount;
        }
        return this;
    }

    public int getBalanceAmount() {
        return balanceAmount;
    }
}
