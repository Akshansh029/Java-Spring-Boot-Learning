package designPatterns.Facade;

public class NotificationService {
    public void sendOrderConfirmation(String email, String orderId) {
        System.out.println("Order confirmation sent to " + email);
    }
}
