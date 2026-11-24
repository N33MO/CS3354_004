package module6.assertions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class HelloWorldTest {

    @Test
    void testAssertArrayEquals_matchesEqualArrays() {
        char[] expected = {'J', 'u', 'p', 'i', 't', 'e', 'r'};
        char[] actual = "Jupiter".toCharArray();

        assertArrayEquals(expected, actual, "Arrays should be equal");
    }

    @Test
    void testAssertEquals_comparesValuesNotReferences() {
        String expected = "Jupiter";
        String actual = new String("Jupiter");   // different object, same value

        assertEquals(expected, actual, "assertEquals compares values");
        assertNotSame(expected, actual, "...but these are two distinct objects");
    }

    @Test
    void testAssertEquals_needsADeltaForDoubles() {
        double sum = 0.1 + 0.2;

        // Neither 0.1 nor 0.2 is exactly representable in binary floating
        // point, so the sum is 0.30000000000000004 -- high by about 5.6E-17.
        assertNotEquals(0.3, sum, "0.1 + 0.2 is not exactly 0.3");

        // Uncomment to watch the naive assertion fail:
        //    assertEquals(0.3, sum);
        // AssertionFailedError: expected: <0.3> but was: <0.30000000000000004>

        // The three-argument form passes when the values agree within a
        // tolerance. Use this form for any double or float.
        assertEquals(0.3, sum, 1e-9, "0.1 + 0.2 equals 0.3 within 1e-9");

        // The tolerance is a judgment call, not a magic switch -- one smaller
        // than the error still fails. Uncomment to see:
        //    assertEquals(0.3, sum, 1e-18);
        // AssertionFailedError: expected: <0.3> but was: <0.30000000000000004>
    }

    @Test
    void testAssertTrueAndFalse_checkBooleanResults() {
        String greeting = new HelloWorld().greet();

        // Reach for assertTrue/assertFalse when no more specific assertion
        // fits -- typically on a boolean that the code under test returned.
        assertTrue(greeting.startsWith("Hello"), "should start with Hello");
        assertFalse(greeting.isEmpty(), "should not be empty");

        // These report only "expected: <true> but was: <false>", naming
        // neither the value nor the condition, so the message argument is what
        // tells you which check broke. Prefer a specific assertion when one
        // exists: assertEquals would have printed both strings.
    }

    @Test
    void testAssertSame_distinguishesObjectReferences() {
        HelloWorld tester1 = new HelloWorld();
        HelloWorld tester2 = new HelloWorld();

        assertSame(tester1, tester1);
        assertNotSame(tester1, tester2);
    }

    @Test
    void testAssertNotNull_acceptsInstantiatedObject() {
        HelloWorld tester = new HelloWorld();

        assertNotNull(tester, "The tester should not be null");
    }

    @Test
    void testAssertNull_acceptsNullReference() {
        HelloWorld tester = null;

        assertNull(tester, "The tester should be null");
    }

    @Disabled("Intentional failure example kept for classroom discussion")
    @Test
    void testFail_demonstratesIntentionalFailure() {
        fail("Intentional failure example");
    }

    @Test
    void testAssertAll_groupsMultipleAssertions() {
        HelloWorld tester1 = new HelloWorld();

        assertAll(
            "heading",
            () -> assertEquals(4, 2 * 2, "4 is 2 times 2"),
            () -> assertEquals("java", "JAVA".toLowerCase()),
            () -> assertSame(tester1, tester1, "Object references should match")
        );
    }

    @Test
    void testAssertIterableEquals_matchesEquivalentLists() {
        Iterable<String> al = new ArrayList<>(Arrays.asList("Java", "Junit", "Test"));
        Iterable<String> ll = new LinkedList<>(Arrays.asList("Java", "Junit", "Test"));

        assertIterableEquals(al, ll);
    }

    @Test
    void testAssertNotEquals_rejectsDifferentValues() {
        Integer value = 5;

        assertNotEquals(0, value, "The result cannot be 0");
    }

    @Test
    void testAssertThrows_catchesNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("One"));
    }

    @Test
    void testAssertTimeout_completesWithinExpectedDuration() {
        assertTimeout(Duration.ofMillis(500), () -> Thread.sleep(50));

        // Note: assertTimeout lets the task run to completion and THEN checks
        // how long it took, so a task that hangs still hangs the test.
        // assertTimeoutPreemptively aborts the task the moment the deadline
        // passes -- but it runs the task on another thread, which breaks
        // anything relying on thread-local state.
    }
}
