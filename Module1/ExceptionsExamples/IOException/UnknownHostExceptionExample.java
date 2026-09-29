/**
 * Title: Java Exceptions Example - UnknownHostException
 * 
 * From:
 *  - M1-3:Basic Java Programming
 * 
 * Problem statement:
 * This example shows Java exceptions: UnknownHostException
 * Thia is a checked exception.
 * 
 * Why it occurs (in this code): 
 * InetAddress.getByName is called with a host name that cannot be resolved by 
 * DNS, so Java throws UnknownHostException.
 * 
 * @date 2026-01-25
 */

package Module1.ExceptionsExamples.IOException;

import java.net.InetAddress;

public class UnknownHostExceptionExample {
    public static void main(String[] args) throws Exception {
        InetAddress.getByName("non-exist-host.example");
    }
}
