package decorator;

public class Main {
	public static void main(String[] args) {
      
        Coffee coffee = new BasicCoffee();
        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Price: BDT " + coffee.getPrice());

        Coffee milkCoffee = new MilkDecorator(coffee);
        System.out.println("\nDescription: " + milkCoffee.getDescription());
        System.out.println("Price: BDT " + milkCoffee.getPrice());

        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println("\nDescription: " + sugarMilkCoffee.getDescription());
        System.out.println("Price: BDT " + sugarMilkCoffee.getPrice());
        
        Coffee sugarWhippedCreamCoffee = new SugarDecorator(new WhippedCreamDecorator(new BasicCoffee()));
        System.out.println("\nDescription: " + sugarWhippedCreamCoffee.getDescription());
        System.out.println("Price: BDT " + sugarWhippedCreamCoffee.getPrice());
    }
}
