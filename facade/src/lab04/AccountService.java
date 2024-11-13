package lab04;

public class AccountService {

	private String accNumber = "3564-9807-2344-2024";
	
	public boolean checkAccount(String cardNumber) {
		System.out.println("AccountService: checking account for card " + cardNumber);
		return accNumber.equals(cardNumber);
	}
}
