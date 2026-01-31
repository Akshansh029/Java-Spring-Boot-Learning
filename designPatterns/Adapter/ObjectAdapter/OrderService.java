package designPatterns.Adapter.ObjectAdapter;

public class OrderService {
    private final PaymentProcessor paymentProcessor;

    public OrderService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(String customerId, double totalAmount) {
        System.out.println("Processing order for customer: " + customerId);

        boolean success = paymentProcessor.processPayment(customerId, totalAmount);

        if (success) {
            String txnId = paymentProcessor.getTransactionId();
            System.out.println("Payment successful! Transaction ID: " + txnId);
        } else {
            System.out.println("Payment failed!");
        }
    }
}