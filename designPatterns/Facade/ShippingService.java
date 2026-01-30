package designPatterns.Facade;

public class ShippingService {
    public String createShipment(String address, String productId) {
        System.out.println("Creating shipment to: " + address);
        return "SHIP-" + System.currentTimeMillis();
    }

    public void scheduleDelivery(String shipmentId) {
        System.out.println("Scheduling delivery for: " + shipmentId);
    }
}

