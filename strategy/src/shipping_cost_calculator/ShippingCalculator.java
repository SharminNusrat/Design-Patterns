package shipping_cost_calculator;

public class ShippingCalculator {
	private ShippingStrategy shippingStrategy;
	
	public void setShippingStrategy(ShippingStrategy shippingStrategy) {
		this.shippingStrategy = shippingStrategy;
	}
	
	public double calculateShippingCost(double packageWeight) {
		if(shippingStrategy != null) {
			return shippingStrategy.calculateCost(packageWeight);
		}
		else {
			throw new IllegalStateException("Shipping strategy is not set.");
		}
	}
}
