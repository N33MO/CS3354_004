package Module5.solid.lsp;

public class Demo3 {
    
}

/**
 * ReadOnlyAccount extends BankAccount but throws exceptions on 
 * deposit() and withdraw() — methods the parent class explicitly 
 * promises to support.
 */

// BEFORE
class BankAccount {
  protected double balance;

  public void deposit(double amount) { balance += amount; }
  public void withdraw(double amount) { balance -= amount; }
  public double getBalance() { return balance; }
}

class ReadOnlyAccount extends BankAccount {
  @Override
  public void deposit(double amount) {
    throw new UnsupportedOperationException();
  }
  @Override
  public void withdraw(double amount) {
    throw new UnsupportedOperationException();
  }
}

class PaymentService {
  public void processPayment( BankAccount account, double amount) {
    account.withdraw(amount); // crashes with ReadOnlyAccount
  }
}


// AFTER
interface Readable { double getBalance(); }

interface Writable {
  void deposit(double amount);
  void withdraw(double amount);
}

class BankAccount implements Readable, Writable {
  private double balance;
  public void deposit(double amount)  { balance += amount; }
  public void withdraw(double amount) { balance -= amount; }
  public double getBalance() { return balance; }
}

class ReadOnlyAccount implements Readable {
  private double balance;
  public ReadOnlyAccount(double balance) { this.balance = balance; }
  public double getBalance() { return balance; }
}

class PaymentService {
  public void processPayment(
      Writable account, double amount) {
    account.withdraw(amount); // ReadOnlyAccount cannot be passed
  }
}


