package lab04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRegistry {

	private final Map<String, Product> registry = new HashMap<>();
	
	public ProductRegistry() {
	}
	
	public Product getProduct(String key) {
		return registry.get(key).clone();
	}
	
	public void put (List<Product> products) {
		products.forEach(product -> registry.put(product.getName() + " " + product.getCategory(), product));
	}
}
