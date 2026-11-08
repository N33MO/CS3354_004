package Module5.strategy.duckExample.ducks;

import Module5.strategy.duckExample.flyBehaviors.FlyNoWay;
import Module5.strategy.duckExample.quackBehaviors.MuteQuack;

public class DecoyDuck extends Duck {
	public DecoyDuck() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new MuteQuack());
	}
	public void display() {
		System.out.println("I'm a duck Decoy");
	}
}
