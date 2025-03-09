package decorator;

public class SugarDecorator extends CoffeeDecorator{
	public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double getPrice() {
        return decoratedCoffee.getPrice() + 20.0;
    }
}
