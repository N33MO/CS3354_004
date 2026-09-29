/**
 * Title: Java Custom Exception Example
 * 
 * From:
 *  - M1-3:Basic Java Programming
 * 
 * Problem statement:
 * This example shows how Java custom exception work
 * 
 * @date 2026-01-26
 */

package Module1.ExceptionsExamples;

class InsufficientFundsException extends IllegalArgumentException {
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}

public class CustomException {
    public static void main(String[] args) {
        double balance = 1000.0;
        withdraw(balance, 1200);
    }

    public static void withdraw(double balance, double amount) {
        if (amount > balance) throw new InsufficientFundsException("Not enough balance");
    }
    
}