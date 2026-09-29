/**
 * Title: Java Exceptions Example - ArithmeticException
 * 
 * From:
 *  - M1-3:Basic Java Programming
 * 
 * Problem statement:
 * This example shows Java exceptions: ArithmeticException
 * Thia is an unchecked exception.
 * 
 * Why it occurs (in this code):
 * The expression 10 / 0 attempts integer division by zero, which triggers an 
 * ArithmeticException.
 * 
 * @date 2026-01-25
 */

package Module1.ExceptionsExamples.RuntimeException;

public class ArithmeticExceptionExample {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;
        int result = divide(numerator, denominator);
        System.out.println("Integer Division Result: " + result);

        double numF = 10.0;
        double denF = 0.0;
        double resF = divide(numF, denF);
        System.out.println("Floating-point Division Result: " + resF);
    }

    public static int divide(int numerator, int denominator) {
        return numerator / denominator;
    }

    public static double divide(double numerator, double denominator) {
        return numerator / denominator;
    }
}
