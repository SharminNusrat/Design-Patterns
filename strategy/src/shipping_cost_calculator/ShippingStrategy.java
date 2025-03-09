package shipping_cost_calculator;

public interface ShippingStrategy {
	public abstract double calculateCost(double packageWeight);
}
