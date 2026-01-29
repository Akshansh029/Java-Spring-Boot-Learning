package designPatterns.Singleton;

//Enum-based (simplest, thread-safe)
public enum ConfigManager {
    INSTANCE;
    private String config = "default";
    public String getConfig() { return config; }
}
// Usage: ConfigManager.INSTANCE.getConfig();