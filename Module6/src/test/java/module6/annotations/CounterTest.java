package module6.annotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * A tour of the JUnit annotations, arranged so the console output tells the
 * story. Run this class on its own and read the printed lines in order:
 *
 * <pre>
 * &#64;BeforeAll    once, before any test
 *   &#64;BeforeEach    before each test
 *   ... a test runs ...
 *   &#64;AfterEach     after each test
 *   &#64;BeforeEach    before the next test
 *   ...
 * &#64;AfterAll     once, after every test
 * </pre>
 *
 * The indentation of the output mirrors that nesting.
 */
class CounterTest {

    private Counter counter;

    /**
     * Runs ONCE before any test in this class -- use it for setup that is
     * expensive and safe to share, such as opening a database connection.
     *
     * It must be static. JUnit creates a brand new instance of the test class
     * for every test method, so before the first test there is no single
     * instance that a non-static method could belong to.
     */
    @BeforeAll
    static void setUpClass() {
        System.out.println("@BeforeAll  - once, before any test");
    }

    /** Runs ONCE after every test. Static for the same reason. */
    @AfterAll
    static void tearDownClass() {
        System.out.println("@AfterAll   - once, after every test");
    }

    /**
     * Runs before EVERY test. This is what makes each test independent: every
     * test below starts with its own brand new Counter sitting at zero.
     */
    @BeforeEach
    void createCounter() {
        counter = new Counter();
        System.out.println("  @BeforeEach - fresh Counter");
    }

    /** Runs after EVERY test. */
    @AfterEach
    void releaseCounter() {
        counter = null;
        System.out.println("  @AfterEach  - cleaned up");
    }

    @Test
    void incrementOnce() {
        counter.increment();
        assertEquals(1, counter.getCount());
    }

    /**
     * Proof that @BeforeEach really did run again: this test also starts from
     * zero, even though the test above already incremented a Counter. Without
     * @BeforeEach, tests would leak state into each other and start failing
     * depending on the order they happened to run in.
     */
    @Test
    void incrementTwice() {
        counter.increment();
        counter.increment();
        assertEquals(2, counter.getCount());
    }

    /**
     * @DisplayName gives the test a readable label in reports and in the
     * VS Code test explorer, instead of showing the bare method name.
     */
    @Test
    @DisplayName("a brand new Counter starts at zero")
    void startsAtZero() {
        assertEquals(0, counter.getCount());
    }

    /**
     * @Timeout fails the test if it runs longer than the limit. This is the
     * declarative form, which covers the whole method; HelloWorldTest shows
     * assertTimeout, the assertion form, which wraps one specific call.
     */
    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void incrementingManyTimesIsFast() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
        assertEquals(1000, counter.getCount());
    }

    /**
     * @Disabled skips the test and reports the reason instead of failing.
     * Always give a reason -- a skipped test with no explanation is a mystery
     * to whoever reads the report next.
     */
    @Test
    @Disabled("Example of a skipped test -- delete the annotation to run it")
    void notYetImplemented() {
        assertEquals(99, counter.getCount());
    }

    /**
     * @ParameterizedTest runs the SAME body once per supplied value, so three
     * values here mean three tests in the report. Note that the method takes a
     * parameter, which a plain @Test method never does.
     *
     * See MathUtilsTest for @ValueSource with a boundary case, and
     * StudentGradeTest for @CsvSource, which supplies several arguments at once.
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void incrementsOncePerCall(int times) {
        for (int i = 0; i < times; i++) {
            counter.increment();
        }
        assertEquals(times, counter.getCount());
    }
}
