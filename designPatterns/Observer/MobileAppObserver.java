package designPatterns.Observer;

public class MobileAppObserver implements Observer {
    private final String userId;

    public MobileAppObserver(String userId) {
        this.userId = userId;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("[MOBILE APP - " + userId + "] Push notification: "
                + stockSymbol + " is now $" + price);
    }
}
