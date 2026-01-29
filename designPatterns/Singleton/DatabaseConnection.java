package designPatterns.Singleton;

public class DatabaseConnection {
    // volatile ensures visibility across threads
    private static volatile DatabaseConnection instance;
    private String connectionString;

    // Private constructor prevents external instantiation
    private DatabaseConnection() {
        this.connectionString = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("Database connection initialized");
    }

    // Double-checked locking for thread safety
    public static DatabaseConnection getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (DatabaseConnection.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public void executeQuery(String sql) {
        System.out.println("Executing: " + sql + " on " + connectionString);
    }
}