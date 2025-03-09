package strategy1;

public class CryptoPayment implements PaymentStrategy{
	private String walletAddress;
	
	public CryptoPayment(String walletAddress) {
		this.walletAddress = walletAddress;
	}
	
	@Override
	public void pay(double amount) {
		System.out.println("Pay $" + amount + " using Cryptocurrency (Wallet: " + walletAddress + ")");
	}
}
