package designPatterns.Observer;

public class EmailObserver implements Observer {
    private final String email;
    private final double alertThreshold;

    public EmailObserver(String email, double alertThreshold) {
        this.email = email;
        this.alertThreshold = alertThreshold;
    }

    @Override
    public void update(String stockSymbol, double price) {
        // Only send email if price crosses threshold
        if (price > alertThreshold) {
            System.out.println("[EMAIL] Sending to " + email + ": "
                    + stockSymbol + " crossed $" + alertThreshold
                    + " (now $" + price + ")");
        }
    }
}
