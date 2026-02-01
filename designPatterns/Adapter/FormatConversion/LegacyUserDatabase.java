package designPatterns.Adapter.FormatConversion;

// Adaptee - Legacy database system with different data structure
public class LegacyUserDatabase {
    // Legacy system stores data as pipe-delimited strings
    public String getUserRecord(int userId) {
        System.out.println("Legacy DB: Fetching user " + userId);
        // Format: id|username|email
        return userId + "|john_doe|john@example.com";
    }

    public void insertUserRecord(String record) {
        System.out.println("Legacy DB: Inserting record: " + record);
        // Expects format: id|username|email
    }
}
