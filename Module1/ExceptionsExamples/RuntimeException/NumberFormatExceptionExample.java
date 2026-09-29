/**
 * Title: Java Exceptions Example - NumberFormatException
 * 
 * From:
 *  - M1-3:Basic Java Programming
 * 
 * Problem statement:
 * This example shows Java exceptions: NumberFormatException
 * Thia is an unchecked exception.
 * 
 * Why it occurs (in this code): 
 * Integer.parseInt("12a") fails because the string contains a non-digit 
 * character ('a'), so it cannot be parsed as an int, causing 
 * NumberFormatException.
 * 
 * @date 2026-01-25
 */

package Module1.ExceptionsExamples.RuntimeException;

public class NumberFormatExceptionExample {
    public static void main(String[] args) {
        int x = Integer.parseInt("12a");
    }
}
