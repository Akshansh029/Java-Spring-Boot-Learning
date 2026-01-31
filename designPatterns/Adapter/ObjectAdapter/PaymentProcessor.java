package designPatterns.Adapter.ObjectAdapter;

public interface PaymentProcessor {
    boolean processPayment(String customerId, double amount);
    String getTransactionId();
}