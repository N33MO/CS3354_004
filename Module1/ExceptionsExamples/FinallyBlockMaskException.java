/**
 * Title: Java Try-Catch-Finally Example
 * 
 * From:
 *  - M1-3:Basic Java Programming
 * 
 * Problem statement:
 * This example shows how Java try-catch-finally block work
 * 
 * @date 2026-01-26
 */

package Module1.ExceptionsExamples;

public class FinallyBlockMaskException {
    public static void main(String[] args) {
        
        try {
            throw new RuntimeException("Original from try block.");
        } catch (RuntimeException e) {
            throw new RuntimeException("Another from catch block.");
        } finally {
            throw new RuntimeException("Exception from finally block.");
        }
    }
}

