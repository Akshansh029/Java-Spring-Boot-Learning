package designPatterns.Proxy.VirtualProxy;

// Subject interface - both real object and proxy implement this
public interface DatabaseConnection {
    void executeQuery(String sql);
}