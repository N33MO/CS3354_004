package module6.annotations;

/**
 * A deliberately tiny class with mutable state.
 *
 * The state is the point: because a Counter remembers its count, the test
 * lifecycle hooks in CounterTest have something real to set up and tear down.
 */
public class Counter {
    private int count;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
