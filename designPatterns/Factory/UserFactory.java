package designPatterns.Factory;

public class UserFactory {
    public static User createUser(String type) {
        return switch (type.toLowerCase()) {
            case "admin" -> new Admin();
            case "guest" -> new Guest();
            default -> throw new IllegalArgumentException("Unknown user type: " + type);
        };
    }

    public static void main(String[] args) {
        User user1 = createUser("admin");
        User user2 = createUser("guest");

        user1.displayRole();
        user2.displayRole();
    }
}
