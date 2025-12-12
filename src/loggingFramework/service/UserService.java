package loggingFramework.service;

import loggingFramework.factory.LoggerFactory;
import loggingFramework.logger.LogLevels;
import loggingFramework.logger.LogMode;
import loggingFramework.logger.Logger;

public class UserService {
    private final Logger logger;

    public UserService(LogMode mode) {
        this.logger = LoggerFactory.getLogger(mode);
    }

    public void createUser(String name){
        logger.log(LogLevels.DEBUG, "Inside User Service");
    }
}
