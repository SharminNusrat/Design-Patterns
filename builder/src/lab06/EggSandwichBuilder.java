package lab06;

public class EggSandwichBuilder implements SandwichBuilder{

	public Sandwich sandwich = new Sandwich();
	
	public void chooseBread() {
		sandwich.setBread("Toasted bread");
	}
	
	public void addFilling() {
		sandwich.setFilling("Fried Egg");;
	}
	
	public void addAccompaniment() {
		sandwich.setAccompaniment("Sauce");
	}
	
	public Sandwich getSandwich() {
		return sandwich;
	}
}
