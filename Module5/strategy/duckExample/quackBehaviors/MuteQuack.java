package Module5.strategy.duckExample.quackBehaviors;

public class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}
