package Module5.solid.ocp;

public class Demo1 {
    
}

/**
 * PaymentProcessor uses an if/else chain to handle each payment type. 
 * Every new payment method forces you to reopen and edit this class.
 */

// BEFORE
class PaymentProcessor {
    public void process(String type, double amount) {
        if (type.equals("creditCard")) {
            System.out.println(
                    "Credit card: " + amount);
        } else if (type.equals("paypal")) {
            System.out.println(
                    "PayPal: " + amount);
        }
        // new method? edit this class.
    }
}

// AFTER
interface PaymentMethod {
    void processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Credit card: " + amount);
    }
}

// Adding Zelle = new class only.
// PaymentProcessor is never touched.
class PaymentProcessor {
    public void process(
            PaymentMethod method, double amount) {
        method.processPayment(amount);
    }
}

