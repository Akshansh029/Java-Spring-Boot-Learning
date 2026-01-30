package designPatterns.Proxy.VirtualProxy;

// Proxy - delays creation of expensive object
public class DatabaseConnectionProxy implements DatabaseConnection {
    private String connectionUrl;
    private RealDatabaseConnection realConnection; // Created only when needed

    public DatabaseConnectionProxy(String connectionUrl) {
        this.connectionUrl = connectionUrl;
        System.out.println("Proxy created (real connection not yet established)");
    }

    @Override
    public void executeQuery(String sql) {
        // Lazy initialization - create real object only when first needed
        if (realConnection == null) {
            System.out.println("First query - initializing real connection...");
            realConnection = new RealDatabaseConnection(connectionUrl);
        }

        // Delegate to real object
        realConnection.executeQuery(sql);
    }
}
