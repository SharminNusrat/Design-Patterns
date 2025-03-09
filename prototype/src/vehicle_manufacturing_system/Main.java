package vehicle_manufacturing_system;

import java.util.HashMap;
import java.util.Map;

// Prototype: Interface for cloning objects
interface VehiclePrototype {
    VehiclePrototype clone();
    void displayDetails();
}

// Concrete Prototype: Represents a Vehicle
class Vehicle implements VehiclePrototype {
    private String type;
    private String color;
    private String engine;

    public Vehicle(String type, String color, String engine) {
        this.type = type;
        this.color = color;
        this.engine = engine;
    }

    // Copy constructor for cloning
    public Vehicle(Vehicle vehicle) {
        this.type = vehicle.type;
        this.color = vehicle.color;
        this.engine = vehicle.engine;
    }

    @Override
    public VehiclePrototype clone() {
        return new Vehicle(this); // Use the copy constructor to create a clone
    }

    @Override
    public void displayDetails() {
        System.out.println("Vehicle Type: " + type);
        System.out.println("Vehicle Color: " + color);
        System.out.println("Vehicle Engine: " + engine);
        System.out.println("-----------------------------");
    }

    // Setters for modifying the cloned vehicle
    public void setColor(String color) {
        this.color = color;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}

// Prototype Registry: Manages a collection of prototypes
class VehicleRegistry {
    private static final Map<String, VehiclePrototype> prototypes = new HashMap<>();

    // Add a prototype to the registry
    public static void addPrototype(String key, VehiclePrototype prototype) {
        prototypes.put(key, prototype);
    }

    // Get a prototype from the registry and clone it
    public static VehiclePrototype getPrototype(String key) {
        VehiclePrototype prototype = prototypes.get(key);
        if (prototype != null) {
            return prototype.clone(); // Return a clone of the prototype
        }
        return null;
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        // Create and register predefined vehicle prototypes
        VehiclePrototype sedan = new Vehicle("Sedan", "Black", "V6");
        VehiclePrototype suv = new Vehicle("SUV", "White", "V8");
        VehiclePrototype truck = new Vehicle("Truck", "Blue", "V8");

        VehicleRegistry.addPrototype("Sedan", sedan);
        VehicleRegistry.addPrototype("SUV", suv);
        VehicleRegistry.addPrototype("Truck", truck);

        // Clone and customize vehicles from the registry
        VehiclePrototype clonedSedan = VehicleRegistry.getPrototype("Sedan");
        if (clonedSedan != null) {
            ((Vehicle) clonedSedan).setColor("Red"); // Customize the color
            System.out.println("Cloned Sedan (Customized):");
            clonedSedan.displayDetails();
        }

        VehiclePrototype clonedSUV = VehicleRegistry.getPrototype("SUV");
        if (clonedSUV != null) {
            ((Vehicle) clonedSUV).setEngine("V6 Turbo"); // Customize the engine
            System.out.println("Cloned SUV (Customized):");
            clonedSUV.displayDetails();
        }

        VehiclePrototype clonedTruck = VehicleRegistry.getPrototype("Truck");
        if (clonedTruck != null) {
            System.out.println("Cloned Truck (Original):");
            clonedTruck.displayDetails();
        }
    }
}