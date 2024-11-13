package lab04;

public class SecurityService {

	private String PIN = "3424";
	
	public boolean checkSecurityPIN(String cardNumber, String securityPIN) {
		System.out.println("SecurityService: verifying PIN for card " + cardNumber);
		return PIN.equals(securityPIN);
	}
}
