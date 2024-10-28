package lab04;

public class Electronic extends Product{

	private int storage;
	private String batteryLife;
	
	public Electronic(String name, String category, double price, int storage, String batteryLife) {
		super(name, category, price);
		this.storage = storage;
		this.batteryLife = batteryLife;
	}
	
	public Electronic(Electronic target) {
		super(target);
		if(target != null) {
			this.storage = target.storage;
			this.batteryLife = target.batteryLife;
		}
	}
	
	@Override
	public Electronic clone() {
		return new Electronic(this);
	}

	@Override
	public String toString() {
		return "Electronic [storage=" + storage + ", batteryLife=" + batteryLife + ", name=" + name + ", category="
				+ category + ", price=" + price + "]";
	}
}
