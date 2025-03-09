package shipping_cost_calculator;

public class EconomyShipping implements ShippingStrategy{
	@Override
	public double calculateCost(double packageWeight) {
		return packageWeight * 0.8 + 5.0;
	}
}
