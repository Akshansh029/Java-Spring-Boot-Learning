package designPatterns.Adapter.ObjectAdapter;

public class Main {
    public static void main(String[] args) {
        // Using Stripe
        System.out.println("=== Using Stripe ===");
        StripePaymentGateway stripe = new StripePaymentGateway();
        PaymentProcessor stripeAdapter = new StripePaymentAdapter(stripe);
        OrderService orderService1 = new OrderService(stripeAdapter);
        orderService1.checkout("CUST123", 99.99);

        System.out.println("\n=== Using PayPal ===");
        // Switch to PayPal - no changes to OrderService!
        PaypalPaymentService paypal = new PaypalPaymentService();
        PaymentProcessor paypalAdapter = new PaypalPaymentAdapter(paypal);
        OrderService orderService2 = new OrderService(paypalAdapter);
        orderService2.checkout("CUST456", 149.99);
    }
}
