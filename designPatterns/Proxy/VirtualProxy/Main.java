package designPatterns.Proxy.VirtualProxy;

// Client code
public class Main {
    public static void main(String[] args) {
        System.out.println("Creating proxy...");
        DatabaseConnection db = new DatabaseConnectionProxy("jdbc:mysql://localhost:3306/mydb");

        System.out.println("\nProxy created. No connection established yet.");
        System.out.println("Doing other work...\n");

        // Connection is established only when first query is executed
        System.out.println("Executing first query:");
        db.executeQuery("SELECT * FROM users");

        System.out.println("\nExecuting second query:");
        db.executeQuery("SELECT * FROM orders");
        // No delay - connection already exists
    }
}
