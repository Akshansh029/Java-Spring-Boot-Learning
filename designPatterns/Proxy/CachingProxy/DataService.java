package designPatterns.Proxy.CachingProxy;

import java.util.List;

public interface DataService {
    List<String> fetchUserData(String userId);
}
