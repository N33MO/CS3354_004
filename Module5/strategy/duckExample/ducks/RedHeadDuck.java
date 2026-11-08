package Module5.strategy.duckExample.ducks;

import Module5.strategy.duckExample.flyBehaviors.FlyWithWings;
import Module5.strategy.duckExample.quackBehaviors.Quack;

public class RedHeadDuck extends Duck {
 
	public RedHeadDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
 
	public void display() {
		System.out.println("I'm a real Red Headed duck");
	}
}
