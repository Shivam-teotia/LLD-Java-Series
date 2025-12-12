package loggingFramework.logger;

public class FileLogger implements Logger{
    @Override
    public void log(LogLevels level, String message) {
        System.out.println("console in file"+ message);
    }
}
