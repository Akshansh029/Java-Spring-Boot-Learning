package designPatterns.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Concrete Subject - Stock Market
public class StockMarket implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private final Map<String, Double> stockPrices = new HashMap<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("New observer registered. Total: " + observers.size());
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer removed. Total: " + observers.size());
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            // Notify each observer with all stock updates
            stockPrices.forEach(observer::update);
        }
    }

    // Business logic - updates stock price
    public void setStockPrice(String symbol, double price) {
        System.out.println("\n[MARKET] " + symbol + " price updated to $" + price);
        stockPrices.put(symbol, price);
        notifyObservers(); // Automatically notify all observers
    }
}
