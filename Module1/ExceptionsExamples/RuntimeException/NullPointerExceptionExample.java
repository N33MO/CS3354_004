/**
 * Title: Java Exceptions Example - NullPointerException
 * 
 * From:
 *  - M1-3:Basic Java Programming
 * 
 * Problem statement:
 * This example shows Java exceptions: NullPointerException
 * Thia is an unchecked exception.
 * 
 * Why it occurs (in this code): 
 * s is set to null, and calling s.length() attempts to dereference a null 
 * reference, causing NullPointerException.
 * 
 * @date 2026-01-25
 */

package Module1.ExceptionsExamples.RuntimeException;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s.length());
    }
}
