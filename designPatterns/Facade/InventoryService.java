package designPatterns.Facade;

// Complex subsystems that the client shouldn't directly interact with
public class InventoryService {
    public boolean checkStock(String productId, int quantity) {
        System.out.println("Checking inventory for product: " + productId);
        // Complex inventory logic here
        return true; // Simplified for demo
    }

    public void reserveStock(String productId, int quantity) {
        System.out.println("Reserving " + quantity + " units of " + productId);
    }
}
