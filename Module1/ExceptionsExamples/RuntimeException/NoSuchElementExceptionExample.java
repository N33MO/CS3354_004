/**
 * Title: Java Exceptions Example - NoSuchElementException
 * 
 * From:
 *  - M1-3:Basic Java Programming
 * 
 * Problem statement:
 * This example shows Java exceptions: NoSuchElementException
 * Thia is an unchecked exception.
 * 
 * Why it occurs (in this code): 
 * The Scanner is created with an empty input, so calling next() tries to read a
 * token that does not exist, causing NoSuchElementException.
 * 
 * @date 2026-01-25
 */

package Module1.ExceptionsExamples.RuntimeException;

import java.util.Scanner;

public class NoSuchElementExceptionExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner("");
        sc.next();
    }
}
