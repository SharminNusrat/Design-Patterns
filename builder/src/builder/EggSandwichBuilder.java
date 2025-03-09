package builder;

public class EggSandwichBuilder extends SandwichBuilder{
	public void buildBread() {
        sandwich.setBread(new WhiteBread());
    }

    public void buildFilling() {
        sandwich.setFilling(new FriedEgg());
    }

    public void buildSpread() {
        sandwich.setSpread(new Mayonnaise());
    }
}
