package lab04;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Product> products = new ArrayList<>();
		products.add(new Clothes("basicShirt","A-3",700,"white","XL"));
		products.add(new Electronic("Laptop","B-2",80000,8,"80%"));
		
		List<Product> copyProducts = new ArrayList<>();
		for(Product product : products) {
			copyProducts.add(product.clone());
		}
		
		copyProducts.forEach(System.out::println);
		
		System.out.println("===================================================================================");
		
		ProductRegistry registry = new ProductRegistry();
		registry.put(products);
		System.out.println(registry.getProduct("Laptop B-2"));
		System.out.println(registry.getProduct("basicShirt A-3"));

	}

}
