package core.logger;

public class EmailLogger implements IBaseLogger{
    @Override
    public void log(String message) {
        System.out.println("Logged to Email : " + message);
    }
}
