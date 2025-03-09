package lab06;

import java.util.ArrayList;
import java.util.List;

public class Director {
	
//	public SandwichBuilder builder;
//	public Director(SandwichBuilder builder) {
//		this.builder = builder;
//	}
	
	
	public void prepareSandwich(SandwichBuilder builder) {
		builder.chooseBread();
		builder.addFilling();
		builder.addAccompaniment();
	}
	
//	public static List<String> getMenu() {
//        List<String> menu = new ArrayList<>();
//        menu.add("1. Chicken Sandwich");
//        menu.add("2. Egg Sandwich");
//        return menu;
//    }
}
