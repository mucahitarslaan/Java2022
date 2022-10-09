package core.logger;

public class FileLogger implements IBaseLogger{
    @Override
    public void log(String message) {
        System.out.println("Logged to File : " + message);
    }
}
