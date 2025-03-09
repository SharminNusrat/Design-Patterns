package composite1;

import java.util.ArrayList;
import java.util.List;

//Component
interface MenuComponent {
 void display();
}

//Leaf
class MenuItem implements MenuComponent {
 private String name;
 private double price;

 public MenuItem(String name, double price) {
     this.name = name;
     this.price = price;
 }

 @Override
 public void display() {
     System.out.println("MenuItem: " + name + ", Price: $" + price);
 }
}

//Composite
class Menu implements MenuComponent {
 private String name;
 private List<MenuComponent> menuComponents = new ArrayList<>();

 public Menu(String name) {
     this.name = name;
 }

 public void addMenuComponent(MenuComponent menuComponent) {
     menuComponents.add(menuComponent);
 }

 public void removeMenuComponent(MenuComponent menuComponent) {
     menuComponents.remove(menuComponent);
 }

 @Override
 public void display() {
     System.out.println("Menu: " + name);
     for (MenuComponent component : menuComponents) {
         component.display(); // Delegate the display call
     }
 }
}

//Main Class
public class RestaurantMenu {
 public static void main(String[] args) {
     // Individual menu items
     MenuComponent burger = new MenuItem("Burger", 5.99);
     MenuComponent pizza = new MenuItem("Pizza", 8.99);
     MenuComponent fries = new MenuItem("Fries", 2.99);

     // Submenu for drinks
     Menu drinksMenu = new Menu("Drinks");
     drinksMenu.addMenuComponent(new MenuItem("Coke", 1.99));
     drinksMenu.addMenuComponent(new MenuItem("Juice", 2.49));

     // Main menu
     Menu mainMenu = new Menu("Main Menu");
     mainMenu.addMenuComponent(burger);
     mainMenu.addMenuComponent(pizza);
     mainMenu.addMenuComponent(fries);
     mainMenu.addMenuComponent(drinksMenu); // Add drinks menu to the main menu

     // Display the menu structure
     mainMenu.display();
 }
}
