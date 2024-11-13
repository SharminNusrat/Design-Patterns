package lab04;

public class PizzaOrderFacade {

	private AccountService accountService;
	private SecurityService securityService;
	private BalanceService balanceService;
	private LedgerService ledgerService;
	private Notification notification;
	
	public PizzaOrderFacade() {
		accountService = new AccountService();
		securityService = new SecurityService();
		balanceService = new BalanceService();
		ledgerService = new LedgerService();
		notification = new Notification();
	}
	
	public void order(String cardNumber, String securityPIN, double amount, String operationType) {
		System.out.println("PizzaDeliveryFacade: initiating pizza order...");
		System.out.println();
		
		if(!accountService.checkAccount(cardNumber)) {
			System.out.println("PizzaDeliveryFacade: Invalid account.");
			return;
		}
		if(!securityService.checkSecurityPIN(cardNumber, securityPIN)) {
			System.out.println("PizzaDeliveryFacade: Invalid PIN.");
			return;
		}
		if(!balanceService.makeTransaction(cardNumber, amount, operationType)) {
			System.out.println("PizzaDeliveryFacade: Transaction failed.");
			return;
		}
		ledgerService.makeEntry(cardNumber, amount, operationType);
		System.out.println();
		notification.sendNotification();
		System.out.println();
		
		System.out.println("Pizza order has been placed successfully!");
	}
}
