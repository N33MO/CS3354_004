package Module1.ExceptionsExamples;

class DivisionByZeroException extends Exception {
    // Constructor that accepts a custom message
    public DivisionByZeroException(String message) {
        super(message);
    }
}

public class CustomException2 {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (DivisionByZeroException e) {
            System.err.println("DivisionByZeroException caught: " + e.getMessage());
        }
    }

    public static int divide(int numerator, int denominator) throws DivisionByZeroException {
        // By default division by zero throws 'ArithmeticException'
        if (denominator == 0) {
            throw new DivisionByZeroException("Division by zero is not allowed.");
        }
        return numerator / denominator;
    }
}
