package strategy1;

public class PayPalPayment implements PaymentStrategy{
	private String email;
	
	public PayPalPayment(String email) {
		this.email = email;
	}
	
	@Override
	public void pay(double amount) {
		System.out.println("Pay $" + amount + " using paypal (Email: " + email + ")");
	}
}
