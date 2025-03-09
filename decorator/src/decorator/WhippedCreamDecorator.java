package decorator;

public class WhippedCreamDecorator extends CoffeeDecorator{
	public WhippedCreamDecorator(Coffee decoratedCoffee) {
		super(decoratedCoffee);
	}
	
	@Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public double getPrice() {
        return decoratedCoffee.getPrice() + 40.0;
    }
}
