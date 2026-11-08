package Module5.strategy.duckExample.flyBehaviors;

public class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly");
	}
}
