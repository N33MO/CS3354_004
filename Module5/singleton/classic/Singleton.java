package Module5.singleton.classic;

// NOTE: This is not thread safe! See Module5.singleton.threadSafe for the fix,
// and SynchronizedRaceDemo there for what can go wrong without it.

public class Singleton {

	// The private static instance of the class
	private static Singleton uniqueInstance;
	// other useful instance variables here

	// Private constructor so that this class cannot be
	// instantiated from outside this class
	private Singleton() {}

	// Public static method that returns the instance of the class
	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}

	// other useful methods here
	public String getDescription() {
		return "I'm a classic Singleton!";
	}
}
