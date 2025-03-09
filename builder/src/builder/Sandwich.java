package builder;

public class Sandwich {
	private Bread bread;
	private Filling filling;
	private Spread spread;
	
	public void setBread(Bread bread) {
		this.bread = bread;
	}
	
	public void setFilling(Filling filling) {
		this.filling = filling;
	}
	
	public void setSpread(Spread spread) {
		this.spread = spread;
	}
	
	@Override
    public String toString() {
        return String.format("Sandwich: %s, %s, %s", 
            bread.getType(), filling.getType(), spread.getType());
    }
}
