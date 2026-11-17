package Module5.singleton.threadSafe;

public class Singleton {

	// The private static instance of the class
	private static Singleton uniqueInstance;
	// other useful instance variables here

	// Private constructor so that this class cannot be
	// instantiated from outside this class
	private Singleton() {}

	// Adding synchronized makes this thread-safe: only one thread at a time
	// can be inside getInstance(), so two callers cannot both see null and
	// both construct. See SynchronizedRaceDemo for a demonstration.
	public static synchronized Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}

	// other useful methods here
	public String getDescription() {
		return "I'm a thread safe Singleton!";
	}
}
