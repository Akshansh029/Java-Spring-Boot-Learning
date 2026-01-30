package designPatterns.Proxy.CachingProxy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataService dataService = new CachingDataServiceProxy();

        // First call - slow (fetches from database)
        System.out.println("First call:");
        dataService.fetchUserData("user123");

        System.out.println("\n---\n");

        // Second call - fast (returns from cache)
        System.out.println("Second call:");
        dataService.fetchUserData("user123");

        System.out.println("\n---\n");

        // Different user - slow again
        System.out.println("Different user:");
        dataService.fetchUserData("user456");
    }
}