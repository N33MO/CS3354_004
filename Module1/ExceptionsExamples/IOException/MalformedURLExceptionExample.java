/**
 * Title: Java Exceptions Example - MalformedURLException
 * 
 * From:
 *  - M1-3:Basic Java Programming
 * 
 * Problem statement:
 * This example shows Java exceptions: MalformedURLException
 * Thia is a checked exception.
 * 
 * Why it occurs (in this code): 
 * The URI string ("htttp://bad_ural") is not a valid URL (bad scheme/invalid 
 * host characters), so converting it to a URL fails, causing 
 * MalformedURLException.
 * 
 * @date 2026-01-25
 */

package Module1.ExceptionsExamples.IOException;

import java.net.URI;
import java.net.URL;

public class MalformedURLExceptionExample {
    public static void main(String[] args) throws Exception {
        URL url = URI.create("htttp://bad_ural").toURL();
    }
}
