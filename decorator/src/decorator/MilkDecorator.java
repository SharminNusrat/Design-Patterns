package decorator;

public class MilkDecorator extends CoffeeDecorator{
	public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double getPrice() {
        return decoratedCoffee.getPrice() + 30.0;
    }
}
