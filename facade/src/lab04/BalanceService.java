package lab04;

public class BalanceService {

	private double balance = 1000.00;
	
	public boolean makeTransaction(String cardNumber, double amount, String operationType) {
		System.out.println("BalanceService: checking balance for card " + cardNumber);
		
		if(operationType.equalsIgnoreCase("debit")) {
			if(amount <= balance) {
				balance -= amount;
				System.out.println("BalanceService: debited $" + amount + " from card " + cardNumber);
				return true;
			}
			else {
				System.out.println("BalanceService: Insufficient balance...");
				return false;
			}
		}
		else {
			balance += amount;
			System.out.println("BalanceService: credited $" + amount + " from card " + cardNumber);
			return true;
		}
	}
}
