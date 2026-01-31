package designPatterns.Adapter.ObjectAdapter;

public class StripePaymentGateway {
    // Stripe's API has different method names and parameters
    public String charge(String token, int amountInCents) {
        System.out.println("Stripe: Charging $" + (amountInCents / 100.0) + " with token: " + token);
        return "stripe_txn_" + System.currentTimeMillis();
    }

    public boolean verifyToken(String token) {
        System.out.println("Stripe: Verifying token: " + token);
        return token != null && token.startsWith("tok_");
    }
}
