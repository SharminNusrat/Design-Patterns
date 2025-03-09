package strategy1;

public class PaymentContext {
	PaymentStrategy paymentStrategy;
	
	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	
	public void pay(double amount) {
		if(paymentStrategy == null) {
			throw new IllegalStateException("Payment Strategy is not set.");
		}
		paymentStrategy.pay(amount);
	}
}
