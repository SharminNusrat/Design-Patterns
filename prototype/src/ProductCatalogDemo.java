import java.util.HashMap;
import java.util.Map;

// Abstract base Product Prototype
abstract class Product implements Cloneable {
    protected String id;
    protected String name;
    protected String category;
    protected double basePrice;

    // Core clone method
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed", e);
        }
    }

    // Abstract method for product-specific details
    public abstract void displayDetails();

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double basePrice) { this.basePrice = basePrice; }
}

// Concrete Clothing Product Prototype
class ClothingProduct extends Product {
    private String color;
    private String size;

    public ClothingProduct(String color, String size) {
        this.category = "Clothing";
        this.color = color;
        this.size = size;
    }

    @Override
    public Object clone() {
        ClothingProduct clonedProduct = (ClothingProduct) super.clone();
        // Deep copy of color and size
        clonedProduct.color = this.color;
        clonedProduct.size = this.size;
        return clonedProduct;
    }

    @Override
    public void displayDetails() {
        System.out.printf("Clothing: %s, Color: %s, Size: %s, Price: $%.2f%n", 
                          name, color, size, basePrice);
    }

    // Specific getters and setters
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
}

// Concrete Electronics Product Prototype
class ElectronicsProduct extends Product {
    private int storageCapacity;
    private double batteryLife;

    public ElectronicsProduct(int storageCapacity, double batteryLife) {
        this.category = "Electronics";
        this.storageCapacity = storageCapacity;
        this.batteryLife = batteryLife;
    }

    @Override
    public Object clone() {
        ElectronicsProduct clonedProduct = (ElectronicsProduct) super.clone();
        // Deep copy of specific attributes
        clonedProduct.storageCapacity = this.storageCapacity;
        clonedProduct.batteryLife = this.batteryLife;
        return clonedProduct;
    }

    @Override
    public void displayDetails() {
        System.out.printf("Electronics: %s, Storage: %dGB, Battery: %.1f hrs, Price: $%.2f%n", 
                          name, storageCapacity, batteryLife, basePrice);
    }

    // Specific getters and setters
    public int getStorageCapacity() { return storageCapacity; }
    public void setStorageCapacity(int storageCapacity) { this.storageCapacity = storageCapacity; }
    public double getBatteryLife() { return batteryLife; }
    public void setBatteryLife(double batteryLife) { this.batteryLife = batteryLife; }
}

// Product Prototype Registry
class ProductRegistry {
    private static Map<String, Product> productPrototypes = new HashMap<>();

    // Register initial product prototypes
    public static void initializeRegistry() {
        // Clothing prototypes
        ClothingProduct tShirt = new ClothingProduct("White", "M");
        tShirt.setId("CLOTH_TSHIRT");
        tShirt.setName("Basic T-Shirt");
        tShirt.setBasePrice(19.99);
        productPrototypes.put(tShirt.getId(), tShirt);

        // Electronics prototypes
        ElectronicsProduct smartphone = new ElectronicsProduct(128, 12.5);
        smartphone.setId("ELEC_SMARTPHONE");
        smartphone.setName("Smart Phone X");
        smartphone.setBasePrice(599.99);
        productPrototypes.put(smartphone.getId(), smartphone);
    }

    // Create a clone of a registered product prototype
    public static Product createProduct(String productId) {
        Product prototype = productPrototypes.get(productId);
        if (prototype == null) {
            throw new IllegalArgumentException("Product prototype not found: " + productId);
        }
        return (Product) prototype.clone();
    }

    // Add new prototype to registry
    public static void registerPrototype(Product product) {
        productPrototypes.put(product.getId(), product);
    }
}

// Demonstration
public class ProductCatalogDemo {
    public static void main(String[] args) {
        // Initialize the product registry
        ProductRegistry.initializeRegistry();

        // Create product variants
        Product tShirtVariant1 = ProductRegistry.createProduct("CLOTH_TSHIRT");
        ((ClothingProduct) tShirtVariant1).setColor("Blue");
        ((ClothingProduct) tShirtVariant1).setSize("L");
        tShirtVariant1.setBasePrice(21.99);
        tShirtVariant1.displayDetails();

        Product smartphoneVariant = ProductRegistry.createProduct("ELEC_SMARTPHONE");
        ((ElectronicsProduct) smartphoneVariant).setStorageCapacity(256);
        ((ElectronicsProduct) smartphoneVariant).setBatteryLife(14.0);
        smartphoneVariant.setBasePrice(699.99);
        smartphoneVariant.displayDetails();
    }
}