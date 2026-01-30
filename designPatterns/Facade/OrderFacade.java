package designPatterns.Facade;


// FACADE: Simplifies the entire order workflow
public class OrderFacade {
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    // Constructor injection of all subsystems
    public OrderFacade(InventoryService inventoryService,
                       PaymentService paymentService,
                       ShippingService shippingService,
                       NotificationService notificationService) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.shippingService = shippingService;
        this.notificationService = notificationService;
    }

    /**
     * Single method that coordinates the entire order process
     * Client only calls this - all complexity is hidden
     */
    public String placeOrder(String productId, int quantity,
                             String customerEmail, String address,
                             String cardNumber, double amount) {

        // Step 1: Check inventory
        if (!inventoryService.checkStock(productId, quantity)) {
            return "Order failed: Out of stock";
        }

        // Step 2: Process payment
        String transactionId = paymentService.processPayment(cardNumber, amount);

        // Step 3: Reserve inventory
        inventoryService.reserveStock(productId, quantity);

        // Step 4: Create shipment
        String shipmentId = shippingService.createShipment(address, productId);
        shippingService.scheduleDelivery(shipmentId);

        // Step 5: Send notifications
        paymentService.sendPaymentConfirmation(customerEmail, transactionId);
        notificationService.sendOrderConfirmation(customerEmail, shipmentId);

        return "Order successful! Shipment: " + shipmentId;
    }

    public static void main(String[] args) {
        InventoryService inv = new InventoryService();
        ShippingService ship = new ShippingService();
        PaymentService payment = new PaymentService();
        NotificationService noti = new NotificationService();
        OrderFacade orderService = new OrderFacade(inv, payment, ship, noti);

        String orderResult = orderService.placeOrder("P-029", 2, "akshanshsingh@gmail.com", "252/1, Shantinagar, Bishrampur, Chhattisgarh", "4632-3493-3778", 400);
        System.out.println(orderResult);

    }
}