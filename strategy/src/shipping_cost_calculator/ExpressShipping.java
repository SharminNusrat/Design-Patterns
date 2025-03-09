package shipping_cost_calculator;

public class ExpressShipping implements ShippingStrategy{
	@Override
	public double calculateCost(double packageWeight) {
		return packageWeight * 3.0 + 25.0;
	}
}
