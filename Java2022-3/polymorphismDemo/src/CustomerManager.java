public class CustomerManager {
    private final BaseLogger baseLogger;

    public CustomerManager(BaseLogger baseLogger) {
        this.baseLogger = baseLogger;
    }

    public void add()
    {
        System.out.println("Customer added");
        baseLogger.log("Log message");

    }
}
