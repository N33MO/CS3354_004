/**
 * Title: Java Exceptions Example - FileNotFoundException
 * 
 * From:
 *  - M1-3:Basic Java Programming
 * 
 * Problem statement:
 * This example shows Java exceptions: FileNotFoundException
 * Thia is a checked exception.
 * 
 * Why it occurs (in this code): 
 * The program tries to open "NonExistFile.demo", but that file does not exist 
 * at runtime, so the file open fails and throws FileNotFoundException.
 * 
 * @date 2026-01-25
 */

package Module1.ExceptionsExamples.IOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileNotFoundExceptionExample {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("NonExistFile.demo"));
        // process the file
        in.close();
    }
}
