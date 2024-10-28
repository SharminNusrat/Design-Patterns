package lab04;

public abstract class Product {

	public String name;
	public String category;
	public double price;
	
	public Product(String name, String category, double price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public Product(Product target) {
		if(target != null) {
			this.name = target.name;
			this.category = target.category;
			this.price = target.price;
		}
	}
	
	public abstract Product clone();

	@Override
	public String toString() {
		return "Product [name=" + name + ", category=" + category + "]";
	}
}
