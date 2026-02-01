package designPatterns.Adapter.FormatConversion;

public class Main {
    public static void main(String[] args) {
        // Using legacy database through adapter
        LegacyUserDatabase legacyDb = new LegacyUserDatabase();
        UserRepository userRepo = new LegacyUserRepositoryAdapter(legacyDb);

        // Work with modern User objects
        System.out.println("Fetching user...");
        userRepo.findById(1L).ifPresent(user -> {
            System.out.println("Found: " + user);
        });

        System.out.println("\nSaving new user...");
        User newUser = new User(2L, "jane_smith", "jane@example.com");
        userRepo.save(newUser);

        // Client code doesn't know it's talking to a legacy database!
    }
}
