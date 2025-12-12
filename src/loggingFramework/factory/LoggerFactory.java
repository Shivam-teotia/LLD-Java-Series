package loggingFramework.factory;

import loggingFramework.logger.ConsoleLogger;
import loggingFramework.logger.FileLogger;
import loggingFramework.logger.LogMode;
import loggingFramework.logger.Logger;

public class LoggerFactory {
    public static Logger getLogger(LogMode mode){
        return switch (mode){
            case FILE -> new FileLogger();
            case CONSOLE -> new ConsoleLogger();
            case BOTH -> (level, message) -> {
                new ConsoleLogger().log(level,message);
                new FileLogger().log(level,message);
            };
        };
    }
}
