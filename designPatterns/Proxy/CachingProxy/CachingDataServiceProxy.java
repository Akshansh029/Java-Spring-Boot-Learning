package designPatterns.Proxy.CachingProxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachingDataServiceProxy implements DataService {
    private RealDataService realService;
    private Map<String, List<String>> cache; // In-memory cache

    public CachingDataServiceProxy() {
        this.realService = new RealDataService();
        this.cache = new HashMap<>();
    }

    @Override
    public List<String> fetchUserData(String userId) {
        // Check cache first
        if (cache.containsKey(userId)) {
            System.out.println("Cache HIT for user: " + userId);
            return cache.get(userId);
        }

        // Cache miss - fetch from real service
        System.out.println("Cache MISS for user: " + userId);
        List<String> data = realService.fetchUserData(userId);

        // Store in cache for future requests
        cache.put(userId, data);

        return data;
    }

    // Optional: method to clear cache
    public void clearCache() {
        cache.clear();
        System.out.println("Cache cleared");
    }
}
