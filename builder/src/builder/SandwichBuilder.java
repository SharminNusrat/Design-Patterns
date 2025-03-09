package builder;

public abstract class SandwichBuilder {
	protected Sandwich sandwich;
	
	public Sandwich getSandwich() {
		return sandwich;
	}
	
	public void createNewSandwich() {
		sandwich = new Sandwich();
	}
	
	public abstract void buildBread();
	public abstract void buildFilling();
    public abstract void buildSpread();
}
