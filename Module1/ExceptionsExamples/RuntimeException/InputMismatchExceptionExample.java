/**
 * Title: Java Exceptions Example - InputMismatchException
 * 
 * From:
 *  - M1-3:Basic Java Programming
 * 
 * Problem statement:
 * This example shows Java exceptions: InputMismatchException
 * Thia is an unchecked exception.
 * 
 * Why it occurs (in this code): 
 * The Scanner is reading the text "abc", but nextInt() expects an integer 
 * token, so the input type does not match, causing InputMismatchException.
 * 
 * @date 2026-01-25
 */

package Module1.ExceptionsExamples.RuntimeException;

import java.util.Scanner;

public class InputMismatchExceptionExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner("abc");
        int x = sc.nextInt();
    }
}
