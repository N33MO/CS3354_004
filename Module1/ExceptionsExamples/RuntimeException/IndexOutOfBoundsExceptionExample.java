/**
 * Title: Java Exceptions Example - IndexOutOfBoundsException
 * 
 * From:
 *  - M1-3:Basic Java Programming
 * 
 * Problem statement:
 * This example shows Java exceptions: IndexOutOfBoundsException
 * Thia is an unchecked exception.
 * 
 * Why it occurs (in this code): 
 * arr is empty, but arr.get(1) tries to access index 1, which is outside the 
 * valid index range, causing IndexOutOfBoundsException.
 * 
 * @date 2026-01-25
 */

package Module1.ExceptionsExamples.RuntimeException;

import java.util.ArrayList;

public class IndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.get(1);
    }
}
