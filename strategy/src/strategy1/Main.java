package strategy1;

public class Main {
	public static void main(String[] args) {
		PaymentContext context = new PaymentContext();
		
		context.setPaymentStrategy(new PayPalPayment("hellofromMars@mail.mars.com"));
		context.pay(200);
		
		context.setPaymentStrategy(new CryptoPayment("0xABC123CryptoWallet"));
        context.pay(300);
	}
}
