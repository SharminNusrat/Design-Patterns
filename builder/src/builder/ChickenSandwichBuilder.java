package builder;

public class ChickenSandwichBuilder extends SandwichBuilder{
	@Override
	public void buildBread() {
		sandwich.setBread(new WheatBread());
	}
	
	@Override
	public void buildFilling() {
		sandwich.setFilling(new GrilledChicken());
	}
	
	@Override
	public void buildSpread() {
		sandwich.setSpread(new Cheese());
	}
}
