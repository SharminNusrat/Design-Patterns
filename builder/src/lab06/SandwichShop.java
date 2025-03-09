package lab06;

public class SandwichShop {

	public static void main(String[] args) {

		
		Director director = new Director();
		
		SandwichBuilder chickenSandwichBuilder = new ChickenSandwichBuilder();
		director.prepareSandwich(chickenSandwichBuilder);
		Sandwich chickenSandwich = chickenSandwichBuilder.getSandwich();
		System.out.println("ChickenSandwich Prepared:\n" + chickenSandwich);
		
		System.out.println();
		
		SandwichBuilder eggSandwichBuilder = new EggSandwichBuilder();
		director.prepareSandwich(eggSandwichBuilder);
		Sandwich eggSandwich = eggSandwichBuilder.getSandwich();
		System.out.println("EggSandwich Prepared:\n" + eggSandwich);
	}

}
