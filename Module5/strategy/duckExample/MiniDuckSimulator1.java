package Module5.strategy.duckExample;

import Module5.strategy.duckExample.ducks.Duck;
import Module5.strategy.duckExample.ducks.MallardDuck;
import Module5.strategy.duckExample.ducks.ModelDuck;
import Module5.strategy.duckExample.ducks.RubberDuck;
import Module5.strategy.duckExample.flyBehaviors.FlyRocketPowered;
import Module5.strategy.duckExample.flyBehaviors.FlyWithWings;
import Module5.strategy.duckExample.quackBehaviors.Quack;

public class MiniDuckSimulator1 {
 
	public static void main(String[] args) {
 
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
   
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();

		Duck rubber_duck = new RubberDuck();
		rubber_duck.performFly();
		rubber_duck.performQuack();
		rubber_duck.setFlyBehavior(new FlyWithWings());
		rubber_duck.performFly();

		Duck rubber_duck2 = new RubberDuck();
		rubber_duck2.setFlyBehavior(new FlyWithWings());
		rubber_duck2.setQuackBehavior(new Quack());
		rubber_duck2.performFly();
		rubber_duck2.performQuack();


		

	}
}
