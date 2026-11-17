package Module5.observer.simple;

public class Example {

	public static void main(String[] args) {
		SimpleSubject simpleSubject = new SimpleSubject();
		
		System.out.println("Create three observers");
		SimpleObserver simpleObserver1 = new SimpleObserver("Observer 1");
		SimpleObserver simpleObserver2 = new SimpleObserver("Observer 2");
		SimpleObserver simpleObserver3 = new SimpleObserver("Observer 3");

		System.out.println("Register the observers from setup code");
		simpleSubject.registerObserver(simpleObserver1);
		simpleSubject.registerObserver(simpleObserver2);
		simpleSubject.registerObserver(simpleObserver3);

		System.out.println("Update value");
		simpleSubject.setValue(80);
		
		System.out.println("Remove observer 1");
		simpleSubject.removeObserver(simpleObserver1);

		System.out.println("Update value");
		simpleSubject.setValue(100);

		System.out.println("Create and register observer 4 later");
		SimpleObserver simpleObserver4 = new SimpleObserver("Observer 4");
		simpleSubject.registerObserver(simpleObserver4);
		System.out.println("Update value");
		simpleSubject.setValue(150);

		System.out.println("Reregister observer 1");
		simpleSubject.registerObserver(simpleObserver1);
		System.out.println("Update value");
		simpleSubject.setValue(200);

		System.out.println("Create observer 5 with self-registration constructor");
		SimpleObserver simpleObserver5 = new SimpleObserver("Observer 5", simpleSubject);
		System.out.println("Update value");
		simpleSubject.setValue(250);
	}

}
