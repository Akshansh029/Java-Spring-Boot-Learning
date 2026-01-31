package designPatterns.Adapter.ObjectAdapter;


// Adapter - Makes Stripe work with our PaymentProcessor interface

public class StripePaymentAdapter implements PaymentProcessor {
    private final StripePaymentGateway stripeGateway; // Composition
    private String lastTransactionId;

    public StripePaymentAdapter(StripePaymentGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public boolean processPayment(String customerId, double amount) {
        // Convert customer ID to Stripe token format
        String stripeToken = "tok_" + customerId;

        // Verify token first (Stripe requires this)
        if (!stripeGateway.verifyToken(stripeToken)) {
            System.out.println("Invalid token for customer: " + customerId);
            return false;
        }

        // Convert dollars to cents (Stripe expects cents)
        int amountInCents = (int) (amount * 100);

        // Call Stripe's charge method with adapted parameters
        lastTransactionId = stripeGateway.charge(stripeToken, amountInCents);

        return lastTransactionId != null;
    }

    @Override
    public String getTransactionId() {
        return lastTransactionId;
    }
}
