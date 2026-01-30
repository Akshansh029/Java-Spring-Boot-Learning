package designPatterns.Proxy.CachingProxy;

import java.util.List;

public class RealDataService implements DataService {

    @Override
    public List<String> fetchUserData(String userId) {
        System.out.println("Fetching data from database for user: " + userId);

        // Simulate slow database query
        try {
            Thread.sleep(2000); // 2 second delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Return dummy data
        return List.of("Name: John Doe", "Email: john@example.com", "Age: 30");
    }
}
