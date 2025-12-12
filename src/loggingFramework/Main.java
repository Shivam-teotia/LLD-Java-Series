package loggingFramework;

import loggingFramework.controller.UserController;
import loggingFramework.logger.LogMode;
import loggingFramework.service.UserService;

public class Main {
    public static void main(String[] args){
        LogMode mode = LogMode.BOTH;
        UserService userService =new UserService(mode);
        UserController userController =new UserController(mode,userService);
        userController.createUser("Shivam");
    }
}
