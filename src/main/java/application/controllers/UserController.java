package application.controllers;

import application.models.user.User;
import application.services.UserService;

public class UserController {
    private UserService userService;

    public UserController() {
        userService = new UserService();
    }

    public User findOneById(String id) {
        return this.userService.findOneById(id);
    }

}
