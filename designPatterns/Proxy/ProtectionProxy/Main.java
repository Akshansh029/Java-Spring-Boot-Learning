package designPatterns.Proxy.ProtectionProxy;

public class Main {
    public static void main(String[] args) {
        // Admin user
        Document adminDoc = new DocumentProxy("Confidential Report", "ADMIN");
        adminDoc.displayContent();
        adminDoc.edit("Updated Confidential Report"); // Allowed

        System.out.println("\n---\n");

        // Regular user
        Document userDoc = new DocumentProxy("Public Document", "USER");
        userDoc.displayContent();
        userDoc.edit("Trying to edit"); // Denied
    }
}
