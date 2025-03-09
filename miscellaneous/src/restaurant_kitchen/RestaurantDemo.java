package restaurant_kitchen;

import java.util.ArrayList;
import java.util.List;

// --------- Order and its types (Factory Method) ---------
abstract class Order {
    protected List<String> items;
    protected String orderType;
    protected String customerId;

    public Order(String customerId) {
        this.customerId = customerId;
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    abstract String getDeliveryInstructions();
}

class DineInOrder extends Order {
    private String tableNumber;

    public DineInOrder(String customerId, String tableNumber) {
        super(customerId);
        this.tableNumber = tableNumber;
        this.orderType = "Dine-In";
    }

    @Override
    String getDeliveryInstructions() {
        return "Serve to Table: " + tableNumber;
    }
}

class TakeawayOrder extends Order {
    private String pickupTime;

    public TakeawayOrder(String customerId, String pickupTime) {
        super(customerId);
        this.pickupTime = pickupTime;
        this.orderType = "Takeaway";
    }

    @Override
    String getDeliveryInstructions() {
        return "Ready for pickup at: " + pickupTime;
    }
}

// --------- Order Factory ---------
abstract class OrderFactory {
    abstract Order createOrder(String customerId, String specialInstruction);
}

class DineInOrderFactory extends OrderFactory {
    @Override
    Order createOrder(String customerId, String tableNumber) {
        return new DineInOrder(customerId, tableNumber);
    }
}

class TakeawayOrderFactory extends OrderFactory {
    @Override
    Order createOrder(String customerId, String pickupTime) {
        return new TakeawayOrder(customerId, pickupTime);
    }
}

// --------- Order Processing (Chain of Responsibility) ---------
abstract class OrderHandler {
    protected OrderHandler nextHandler;

    public void setNext(OrderHandler handler) {
        this.nextHandler = handler;
    }

    public abstract void processOrder(Order order);
}

class OrderValidationHandler extends OrderHandler {
    @Override
    public void processOrder(Order order) {
        System.out.println("Validating order...");
        if (nextHandler != null) {
            nextHandler.processOrder(order);
        }
    }
}

class OrderPreparationHandler extends OrderHandler {
    @Override
    public void processOrder(Order order) {
        System.out.println("Preparing order in kitchen...");
        if (nextHandler != null) {
            nextHandler.processOrder(order);
        }
    }
}

class QualityCheckHandler extends OrderHandler {
    @Override
    public void processOrder(Order order) {
        System.out.println("Performing quality check...");
        if (nextHandler != null) {
            nextHandler.processOrder(order);
        }
    }
}

// --------- Observer Pattern ---------
interface OrderObserver {
    void update(Order order, String status);
}

class WaiterNotifier implements OrderObserver {
    @Override
    public void update(Order order, String status) {
        System.out.println("Waiter notified - Order " + order.customerId + ": " + status);
    }
}

class CustomerNotifier implements OrderObserver {
    @Override
    public void update(Order order, String status) {
        System.out.println("Customer " + order.customerId + " notified: " + status);
    }
}

// --------- Decorator Pattern ---------
abstract class OrderDecorator extends Order {
    protected Order order;

    public OrderDecorator(Order order) {
        super(order.customerId);
        this.order = order;
    }
}

class SpicyModification extends OrderDecorator {
    public SpicyModification(Order order) {
        super(order);
    }

    @Override
    String getDeliveryInstructions() {
        return order.getDeliveryInstructions() + " (Extra Spicy)";
    }
}

// --------- Restaurant Management System ---------
class RestaurantManager {
    private List<OrderObserver> observers = new ArrayList<>();
    private OrderHandler orderProcessingChain;

    public RestaurantManager() {
        // Set up the chain of responsibility
        OrderValidationHandler validator = new OrderValidationHandler();
        OrderPreparationHandler preparation = new OrderPreparationHandler();
        QualityCheckHandler qualityCheck = new QualityCheckHandler();

        validator.setNext(preparation);
        preparation.setNext(qualityCheck);

        orderProcessingChain = validator;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(Order order, String status) {
        for (OrderObserver observer : observers) {
            observer.update(order, status);
        }
    }

    public void processOrder(Order order) {
        notifyObservers(order, "Order Received");
        orderProcessingChain.processOrder(order);
        notifyObservers(order, "Order Completed");
    }
}

// --------- Demo Usage ---------
class RestaurantDemo {
    public static void main(String[] args) {
        // Create the restaurant management system
        RestaurantManager restaurant = new RestaurantManager();
        restaurant.addObserver(new WaiterNotifier());
        restaurant.addObserver(new CustomerNotifier());

        // Create order factories
        OrderFactory dineInFactory = new DineInOrderFactory();
        OrderFactory takeawayFactory = new TakeawayOrderFactory();

        // Create and process a dine-in order
        Order dineInOrder = dineInFactory.createOrder("CUST001", "Table 5");
        dineInOrder.addItem("Pasta");
        dineInOrder.addItem("Salad");
        
        // Add spicy modification using decorator
        dineInOrder = new SpicyModification(dineInOrder);

        // Process the order
        System.out.println("\nProcessing Dine-in Order:");
        restaurant.processOrder(dineInOrder);

        // Create and process a takeaway order
        Order takeawayOrder = takeawayFactory.createOrder("CUST002", "18:30");
        takeawayOrder.addItem("Pizza");
        
        System.out.println("\nProcessing Takeaway Order:");
        restaurant.processOrder(takeawayOrder);
    }
}