package builder;

public class SandwichOrderSystem {
	public static void main(String[] args) {
		SandwichDirector director = new SandwichDirector();
		
		SandwichBuilder chickenBuilder = new ChickenSandwichBuilder();
		Sandwich chickenSandwich = director.constructSandwich(chickenBuilder);
		System.out.println(chickenSandwich);
		
		SandwichBuilder eggBuilder = new EggSandwichBuilder();
		Sandwich eggSandwich = director.constructSandwich(eggBuilder);
		System.out.println(eggSandwich);
	}
}
