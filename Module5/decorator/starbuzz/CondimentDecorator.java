package Module5.decorator.starbuzz;

import java.util.Objects;

public abstract class CondimentDecorator extends Beverage {
	protected final Beverage beverage;

	protected CondimentDecorator(Beverage beverage) {
		this.beverage = Objects.requireNonNull(beverage,
				"A condiment must wrap a beverage (or another condiment), not null");
	}

	public abstract String getDescription();
}
