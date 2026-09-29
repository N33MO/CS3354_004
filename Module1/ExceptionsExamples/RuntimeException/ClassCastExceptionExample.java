/**
 * Title: Java Exceptions Example - ClassCastException
 * 
 * From:
 *  - M1-3:Basic Java Programming
 * 
 * Problem statement:
 * This example shows Java exceptions: ClassCastException
 * Thia is an unchecked exception.
 * 
 * Why it occurs (in this code):
 * The variable o actually refers to a String, but the code forces a cast to 
 * Integer, so the runtime cast fails, causing ClassCastException.
 * 
 * @date 2026-01-25
 */

package Module1.ExceptionsExamples.RuntimeException;

public class ClassCastExceptionExample {
    public static void main(String[] args) {
        Object o = "Hello";
        Integer n = (Integer) o;
    }    
}
