package designPatterns.Facade;

public class PaymentService {
    public String processPayment(String cardNumber, double amount) {
        System.out.println("Processing payment of Rs." + amount);
        // Complex payment gateway integration
        return "TXN-" + System.currentTimeMillis();
    }

    public void sendPaymentConfirmation(String email, String transactionId) {
        System.out.println("Sending confirmation to " + email);
    }
}
