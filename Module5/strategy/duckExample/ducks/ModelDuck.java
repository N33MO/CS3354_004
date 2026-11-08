package Module5.strategy.duckExample.ducks;

import Module5.strategy.duckExample.flyBehaviors.FlyNoWay;
import Module5.strategy.duckExample.quackBehaviors.Quack;

public class ModelDuck extends Duck {
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a model duck");
	}
}
