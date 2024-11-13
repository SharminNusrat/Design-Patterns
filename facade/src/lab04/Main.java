package lab04;

public class Main {

	public static void main(String[] args) {
		
		PizzaOrderFacade orderingPizza = new PizzaOrderFacade();
		
		String cardNumber = "3564-9807-2344-2024";
		String securityPIN = "3424";
		double amount = 30.99;
		String operationType = "Debit";
		
		orderingPizza.order(cardNumber, securityPIN, amount, operationType);
	}
}
