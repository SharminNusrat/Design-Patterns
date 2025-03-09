package lab06;

public class ChickenSandwichBuilder implements SandwichBuilder{

	public Sandwich sandwich = new Sandwich();
	
	public void chooseBread() {
		sandwich.setBread("Regular bread");
	}
	
	public void addFilling() {
		sandwich.setFilling("Grilled Chicken");;
	}
	
	public void addAccompaniment() {
		sandwich.setAccompaniment("Cheese");
	}
	
	public Sandwich getSandwich() {
		return sandwich;
	}
}
