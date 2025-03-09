package builder;

public class SandwichDirector {
	 public Sandwich constructSandwich(SandwichBuilder builder) {
	        builder.createNewSandwich();
	        builder.buildBread();
	        builder.buildFilling();
	        builder.buildSpread();
	        return builder.getSandwich();
	 }
}
