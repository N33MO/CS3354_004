package Module5.strategy.duckExample.ducks;

import Module5.strategy.duckExample.flyBehaviors.FlyWithWings;
import Module5.strategy.duckExample.quackBehaviors.Quack;

public class MallardDuck extends Duck {

	public MallardDuck() {

		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();

	}

	public void display() {
		System.out.println("I'm a real Mallard duck");
	}
}
