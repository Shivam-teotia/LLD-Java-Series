package loggingFramework.logger;

public class ConsoleLogger implements Logger{
    @Override
    public void log(LogLevels level, String message) {
        System.out.println("print in console"+ message);
    }
}
