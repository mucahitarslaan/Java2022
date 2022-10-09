package core.logger;

public class DatabaseLogger implements IBaseLogger{
    @Override
    public void log(String message) {
        System.out.println("Logged to Database : " + message);
    }
}
