package designPatterns.Singleton;

//Bill Pugh (lazy, thread-safe, no synchronization)
public class Logger {
    private Logger() {}
    private static class Helper {
        private static final Logger INSTANCE = new Logger();
    }
    public static Logger getInstance() {
        return Helper.INSTANCE;
    }
}
