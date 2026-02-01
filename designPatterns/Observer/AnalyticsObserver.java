package designPatterns.Observer;

public class AnalyticsObserver implements Observer {

    @Override
    public void update(String stockSymbol, double price) {
        // Log to analytics system
        System.out.println("[ANALYTICS] Logged: " + stockSymbol + " = $" + price
                + " at " + System.currentTimeMillis());
    }
}
