package ua.com.alevel;

import ua.com.alevel.controller.UserController;

public class StartProgram {
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.run();
    }
}
