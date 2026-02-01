package designPatterns.Adapter.FormatConversion;
import java.util.Optional;


// Adapter - Converts between modern User objects and legacy string format
public class LegacyUserRepositoryAdapter implements UserRepository {
    private final LegacyUserDatabase legacyDb;

    public LegacyUserRepositoryAdapter(LegacyUserDatabase legacyDb) {
        this.legacyDb = legacyDb;
    }

    @Override
    public Optional<User> findById(Long id) {
        try {
            // Fetch legacy format: "id|username|email"
            String record = legacyDb.getUserRecord(id.intValue());

            // Parse the pipe-delimited string
            String[] parts = record.split("\\|");
            if (parts.length != 3) {
                return Optional.empty();
            }

            // Convert to modern User object
            User user = new User(
                    Long.parseLong(parts[0]),
                    parts[1],
                    parts[2]
            );

            return Optional.of(user);

        } catch (Exception e) {
            System.out.println("Error fetching user: " + e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public void save(User user) {
        // Convert User object to legacy pipe-delimited format
        String record = user.getId() + "|" +
                user.getUsername() + "|" +
                user.getEmail();

        // Save in legacy format
        legacyDb.insertUserRecord(record);
    }
}
