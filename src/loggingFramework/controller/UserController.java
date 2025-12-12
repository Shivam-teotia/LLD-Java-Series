package loggingFramework.controller;

import loggingFramework.factory.LoggerFactory;
import loggingFramework.logger.LogLevels;
import loggingFramework.logger.LogMode;
import loggingFramework.logger.Logger;
import loggingFramework.service.UserService;

public class UserController {
    private final Logger logger;
    private final UserService userService;

    public UserController(LogMode mode, UserService userService) {
        this.logger = LoggerFactory.getLogger(mode);
        this.userService = userService;
    }

    public void createUser(String name){
        logger.log(LogLevels.INFO,"inside controller trying to create user");
        userService.createUser(name);
    }
}
