/**
 * Title: Java Exceptions Example - IllegalArgumentException
 * 
 * From:
 *  - M1-3:Basic Java Programming
 * 
 * Problem statement:
 * This example shows Java exceptions: IllegalArgumentException
 * Thia is an unchecked exception.
 * 
 * Why it occurs (in this code): 
 * main calls setAge(-1), and setAge rejects negative ages by explicitly 
 * throwing IllegalArgumentException.
 * 
 * @date 2026-01-25
 */

package Module1.ExceptionsExamples.RuntimeException;

public class IllegalArgumentExceptionExample {
    public static void main(String[] args) {
        setAge(-1);
    }

    public static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be >= 0");
        }
    }
}
