package Module5.strategy.duckExample.quackBehaviors;

public class FakeQuack implements QuackBehavior {
	public void quack() {
		System.out.println("Qwak");
	}
}
