package shipping_cost_calculator;

public class StandardShipping implements ShippingStrategy{
	@Override
	public double calculateCost(double packageWeight) {
		return packageWeight * 1.5 + 10.0;
	}
}
