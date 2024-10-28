package lab04;

public class Clothes extends Product{

	private String color;
	private String size;

	public Clothes(String name, String category, double price, String color, String size) {
		super(name, category, price);
		this.color = color;
		this.size = size;
	}
	
	public Clothes(Clothes target) {
		super(target);
		if(target != null) {
			this.color = target.color;
			this.size = target.size;
		}
	}
	
	@Override
	public Clothes clone() {
		return new Clothes(this);
	}
	
	@Override
	public String toString() {
		return "Clothes [color=" + color + ", size=" + size + ", name=" + name + ", category=" + category + ", price="
				+ price + "]";
	}
}
