package designPatterns.Observer;

public class Main {
    public static void main(String[] args) {
        // Create subject
        StockMarket market = new StockMarket();

        // Create observers
        Observer mobileApp = new MobileAppObserver("user123");
        Observer emailAlert = new EmailObserver("investor@example.com", 150.0);
        Observer analytics = new AnalyticsObserver();

        // Register observers
        market.registerObserver(mobileApp);
        market.registerObserver(emailAlert);
        market.registerObserver(analytics);

        // Update stock prices - all observers get notified automatically
        market.setStockPrice("AAPL", 145.50);
        market.setStockPrice("GOOGL", 152.30); // Email alert triggered!

        // Remove an observer
        market.removeObserver(emailAlert);

        // This update won't trigger email
        market.setStockPrice("AAPL", 148.00);
    }
}
