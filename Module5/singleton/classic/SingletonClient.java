package Module5.singleton.classic;

public class SingletonClient {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton.getDescription());
		boolean areSame = singleton == singleton2;
		System.out.println("S1 == S2? " + areSame);
	}
}