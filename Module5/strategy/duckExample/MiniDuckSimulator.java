package Module5.strategy.duckExample;

import Module5.strategy.duckExample.ducks.DecoyDuck;
import Module5.strategy.duckExample.ducks.Duck;
import Module5.strategy.duckExample.ducks.MallardDuck;
import Module5.strategy.duckExample.ducks.ModelDuck;
import Module5.strategy.duckExample.ducks.RubberDuck;
import Module5.strategy.duckExample.flyBehaviors.FlyBehavior;
import Module5.strategy.duckExample.flyBehaviors.FlyRocketPowered;
import Module5.strategy.duckExample.quackBehaviors.QuackBehavior;

public class MiniDuckSimulator {
 
	public static void main(String[] args) {
 
		MallardDuck	mallard = new MallardDuck();
		FlyBehavior cantFly = () -> System.out.println("I can't fly");
		QuackBehavior squeak = () -> System.out.println("Squeak");
		RubberDuck	rubberDuckie = new RubberDuck(cantFly, squeak);
		DecoyDuck	decoy = new DecoyDuck();
 
		Duck	 model = new ModelDuck();

		mallard.performQuack();
		rubberDuckie.performQuack();
		decoy.performQuack();
   
		model.performFly();	
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}
}
