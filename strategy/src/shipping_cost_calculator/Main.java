package shipping_cost_calculator;

public class Main {
	public static void main(String[] args) {
		ShippingCalculator shippingCalculator = new ShippingCalculator();
		
		ShippingStrategy expressShipping = new ExpressShipping();
		ShippingStrategy standardShipping = new StandardShipping();
		ShippingStrategy economyShipping = new EconomyShipping();
		
		double packageWeight = 10.0;
		
		shippingCalculator.setShippingStrategy(expressShipping);
	    double expressCost = shippingCalculator.calculateShippingCost(packageWeight);
	    
	    shippingCalculator.setShippingStrategy(standardShipping);
	    double standardCost = shippingCalculator.calculateShippingCost(packageWeight);
	    
	    shippingCalculator.setShippingStrategy(economyShipping);
	    double economyCost = shippingCalculator.calculateShippingCost(packageWeight);
	    
	    System.out.println("Shipping cost for a " + packageWeight + "kg package:");
	    System.out.println("Express Shipping: " + expressCost);
	    System.out.println("Standard Shipping: " + standardCost);
	    System.out.println("Economy Shipping: " + economyCost);
	}
}
