package designPatterns.Adapter.ObjectAdapter;

public class PaypalPaymentAdapter implements PaymentProcessor {
    private final PaypalPaymentService payPalService;
    private String lastTransactionId;

    public PaypalPaymentAdapter(PaypalPaymentService payPalService) {
        this.payPalService = payPalService;
    }

    @Override
    public boolean processPayment(String customerId, double amount) {
        // Convert customer ID to email format (PayPal expects email)
        String email = customerId + "@example.com";

        // Format amount as string (PayPal's API requirement)
        String amountStr = String.format("%.2f", amount);

        // Call PayPal with adapted parameters
        lastTransactionId = payPalService.makePayment(email, amountStr);

        return lastTransactionId != null;
    }

    @Override
    public String getTransactionId() {
        return lastTransactionId;
    }
}
