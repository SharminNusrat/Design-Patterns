package lab04;

public class LedgerService {

	public void makeEntry(String cardNumber, double amount, String operationType) {
		System.out.println("LedgerService: Making a " + operationType + " entry of $" + amount + " for card " + cardNumber);
	}
}
