package Module5.observer.simple;

public class SimpleObserver implements Observer {
	private final String name;
	private int value;

	public SimpleObserver(String name) {
		this.name = name;
	}

	public SimpleObserver(String name, Subject simpleSubject) {
		this(name);
		simpleSubject.registerObserver(this);
	}
	
	public void update(int value) {
		this.value = value;
		display();
	}
	
	public void display() {
		System.out.println(name + " received update. Value: " + value);
	}
}
