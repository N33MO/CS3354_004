package Module5.decorator.starbuzz;


public class StarbuzzCoffee {
 
	public static void main(String args[]) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());
 
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
		// beverage2.cost():13 = .10 + beverage.cost():12
		// beverage2.cost():13 = .10 + .20 + beverage.cost():11
		// beverage2.cost():13 = .10 + .20 + .20 + beverage.cost():10
		// beverage2.cost():13 = .10 + .20 + .20 + .99
 
		Beverage beverage3 = new HouseBlend();
		beverage3 = new Soy(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
	}
}