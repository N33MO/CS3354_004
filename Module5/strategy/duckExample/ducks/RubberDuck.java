package Module5.strategy.duckExample.ducks;

import Module5.strategy.duckExample.flyBehaviors.FlyBehavior;
import Module5.strategy.duckExample.flyBehaviors.FlyNoWay;
import Module5.strategy.duckExample.quackBehaviors.Squeak;
import Module5.strategy.duckExample.quackBehaviors.QuackBehavior;

public class RubberDuck extends Duck {
 
	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}
	
	public RubberDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
		this.flyBehavior = flyBehavior;
		this.quackBehavior = quackBehavior; 
	}
 
	public void display() {
		System.out.println("I'm a rubber duckie");
	}
}
