package Module5.singleton.threadSafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Shows what the synchronized keyword on getInstance() actually prevents.
 *
 * Both singletons below are lazily initialized and identical except for one
 * word: SafeLazySingleton.getInstance() is synchronized. Ten threads race to
 * be the first caller of each.
 *
 * Two things make this demo work, and both matter:
 *
 * 1. The constructors simulate expensive initialization (50 ms). With a cheap
 *    constructor the gap between the null check and the assignment is only a
 *    few nanoseconds, so threads almost never interleave there and even the
 *    unsafe version looks fine. That is exactly why this bug hides in
 *    development and appears in production once startup work grows.
 *
 * 2. Each race runs ONCE per program run. The instance field is static, so
 *    after the first race an instance already exists and there is nothing
 *    left to race over. Do not wrap this in a loop expecting repeated
 *    failures -- run the program again instead.
 *
 * Run from the repository root:
 *   javac Module5/singleton/threadSafe/SynchronizedRaceDemo.java
 *   java Module5.singleton.threadSafe.SynchronizedRaceDemo
 */
class UnsafeLazySingleton {
    private static UnsafeLazySingleton uniqueInstance;

    private UnsafeLazySingleton() {
        simulateExpensiveInit();
    }

    // No synchronized: two threads can both see null and both construct.
    public static UnsafeLazySingleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new UnsafeLazySingleton();
        }
        return uniqueInstance;
    }

    static void simulateExpensiveInit() {
        try {
            Thread.sleep(50);   // reading config, opening a connection, ...
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class SafeLazySingleton {
    private static SafeLazySingleton uniqueInstance;

    private SafeLazySingleton() {
        UnsafeLazySingleton.simulateExpensiveInit();
    }

    // One word different: only one thread may be inside at a time.
    public static synchronized SafeLazySingleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SafeLazySingleton();
        }
        return uniqueInstance;
    }
}

public class SynchronizedRaceDemo {
    private static final int THREAD_COUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(THREAD_COUNT + " threads call getInstance() at once.\n");

        int unsafeCount = raceFor(false);
        System.out.println("WITHOUT synchronized -> distinct instances: " + unsafeCount
                + (unsafeCount > 1 ? "   <-- the singleton guarantee is broken" : ""));

        int safeCount = raceFor(true);
        System.out.println("WITH    synchronized -> distinct instances: " + safeCount
                + (safeCount == 1 ? "   <-- exactly one, as promised" : ""));
    }

    /** Starts THREAD_COUNT threads on one singleton and counts distinct results. */
    private static int raceFor(boolean synchronizedVersion) throws InterruptedException {
        Set<Object> instancesSeen = Collections.synchronizedSet(new HashSet<>());
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> instancesSeen.add(
                    synchronizedVersion
                            ? (Object) SafeLazySingleton.getInstance()
                            : (Object) UnsafeLazySingleton.getInstance()));
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();   // wait for the race to finish before counting
        }
        return instancesSeen.size();
    }
}
