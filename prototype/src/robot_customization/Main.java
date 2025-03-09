package robot_customization;

//Prototype: Interface for cloning objects
interface RobotPrototype {
 RobotPrototype clone();
 void displayDetails();
}

//Concrete Prototype: Represents a Robot
class Robot implements RobotPrototype {
 private String model;
 private String color;
 private String weapons;

 public Robot(String model, String color, String weapons) {
     this.model = model;
     this.color = color;
     this.weapons = weapons;
 }

 // Copy constructor for cloning
 public Robot(Robot robot) {
     this.model = robot.model;
     this.color = robot.color;
     this.weapons = robot.weapons;
 }

 @Override
 public RobotPrototype clone() {
     return new Robot(this); // Use the copy constructor to create a clone
 }

 @Override
 public void displayDetails() {
     System.out.println("Robot Model: " + model);
     System.out.println("Robot Color: " + color);
     System.out.println("Robot Weapons: " + weapons);
     System.out.println("-----------------------------");
 }

 // Setters for modifying the cloned robot
 public void setModel(String model) {
     this.model = model;
 }

 public void setColor(String color) {
     this.color = color;
 }

 public void setWeapons(String weapons) {
     this.weapons = weapons;
 }
}

//Client Code
public class Main {
 public static void main(String[] args) {
     // Create a prototype robot
     RobotPrototype warriorRobot = new Robot("Warrior", "Red", "Sword, Shield");

     // Clone the prototype and customize it
     RobotPrototype clonedRobot1 = warriorRobot.clone();
     ((Robot) clonedRobot1).setColor("Blue"); // Modify the color
     ((Robot) clonedRobot1).setWeapons("Axe, Bow"); // Modify the weapons

     // Clone the prototype again and customize it differently
     RobotPrototype clonedRobot2 = warriorRobot.clone();
     ((Robot) clonedRobot2).setModel("Explorer"); // Modify the model
     ((Robot) clonedRobot2).setWeapons("Laser Gun"); // Modify the weapons

     // Display details of all robots
     System.out.println("Original Robot:");
     warriorRobot.displayDetails();

     System.out.println("Cloned Robot 1 (Customized):");
     clonedRobot1.displayDetails();

     System.out.println("Cloned Robot 2 (Customized):");
     clonedRobot2.displayDetails();
 }
}