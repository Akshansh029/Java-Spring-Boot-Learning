package designPatterns.Adapter.ObjectAdapter;

public class PaypalPaymentService {
    public String makePayment(String email, String amountUSD) {
        System.out.println("PayPal: Processing $" + amountUSD + " for " + email);
        return "PAYPAL-" + System.nanoTime();
    }
}
