package designPatterns.Proxy.VirtualProxy;




// Real Subject - expensive to create

public class RealDatabaseConnection implements DatabaseConnection {
    private String connectionUrl;

    // Constructor simulates expensive initialization (connecting to DB)
    public RealDatabaseConnection(String connectionUrl) {
        this.connectionUrl = connectionUrl;
        System.out.println("Establishing expensive database connection to: " + connectionUrl);
        // Simulate connection delay
        try {
            Thread.sleep(2000); // 2 second delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Connection established!");
    }

    @Override
    public void executeQuery(String sql) {
        System.out.println("Executing query on " + connectionUrl + ": " + sql);
    }
}

