interface Chair {
    void sitOn();
}

interface Table {
    void placeItems();
}

interface Sofa {
    void relaxOn();
}

class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a modern chair.");
    }
}

class ModernTable implements Table {
    @Override
    public void placeItems() {
        System.out.println("Placing items on a modern table.");
    }
}

class ModernSofa implements Sofa {
    @Override
    public void relaxOn() {
        System.out.println("Relaxing on a modern sofa.");
    }
}

class VictorianChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Victorian chair.");
    }
}

class VictorianTable implements Table {
    @Override
    public void placeItems() {
        System.out.println("Placing items on a Victorian table.");
    }
}

class VictorianSofa implements Sofa {
    @Override
    public void relaxOn() {
        System.out.println("Relaxing on a Victorian sofa.");
    }
}

class RusticChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a rustic chair.");
    }
}

class RusticTable implements Table {
    @Override
    public void placeItems() {
        System.out.println("Placing items on a rustic table.");
    }
}

class RusticSofa implements Sofa {
    @Override
    public void relaxOn() {
        System.out.println("Relaxing on a rustic sofa.");
    }
}

interface FurnitureFactory {
    Chair createChair();
    Table createTable();
    Sofa createSofa();
}

class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}

class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}

class RusticFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new RusticChair();
    }

    @Override
    public Table createTable() {
        return new RusticTable();
    }

    @Override
    public Sofa createSofa() {
        return new RusticSofa();
    }
}

class FurnitureFactorySingleton {
    private static volatile FurnitureFactorySingleton instance;
    private static long idCounter = 0;

    private FurnitureFactorySingleton() {}

    public static FurnitureFactorySingleton getInstance() {
        if (instance == null) {
            synchronized (FurnitureFactorySingleton.class) {
                if (instance == null) {
                    instance = new FurnitureFactorySingleton();
                }
            }
        }
        return instance;
    }

    public FurnitureFactory getFactory(String style) {
        switch (style.toLowerCase()) {
            case "modern":
                return new ModernFurnitureFactory();
            case "victorian":
                return new VictorianFurnitureFactory();
            case "rustic":
                return new RusticFurnitureFactory();
            default:
                throw new IllegalArgumentException("Invalid furniture style: " + style);
        }
    }

    public synchronized long generateUniqueId() {
        return ++idCounter;
    }
}

public class Main {
    public static void main(String[] args) {
        FurnitureFactorySingleton factoryManager = FurnitureFactorySingleton.getInstance();

        // Get a Victorian Furniture Factory
        FurnitureFactory victorianFactory1 = factoryManager.getFactory("Victorian");
        Chair victorianChair = victorianFactory1.createChair();
        victorianChair.sitOn();
        System.out.println("Unique ID for Victorian Chair 1: " + factoryManager.generateUniqueId());
        
        FurnitureFactory victorianFactory2 = factoryManager.getFactory("Victorian");
        victorianChair = victorianFactory2.createChair();
        victorianChair.sitOn();
        System.out.println("Unique ID for Victorian Chair 2: " + factoryManager.generateUniqueId());

        // Get a Modern Furniture Factory
        FurnitureFactory modernFactory = factoryManager.getFactory("Modern");
        Table modernTable = modernFactory.createTable();
        modernTable.placeItems();

        // Generate Unique IDs for Products
     
        System.out.println("Unique ID for Modern Table: " + factoryManager.generateUniqueId());
    }
}
