package src.controller.impl;

import src.controller.UserController;
import src.model.User;
import src.service.UserService;
import src.service.impl.UserServiceImpl;

public class UserControllerImpl implements UserController {

    UserService userService = new UserServiceImpl();

    @Override
    public User createUser(String name, long phoneNumber) {
        return userService.createUser(name, phoneNumber);
    }

    @Override
    public void updateUser(User updatedUser) {
        userService.updateUser(updatedUser);
    }

    @Override
    public User logIn(String name, long phoneNumber) {
        return userService.logIn(name, phoneNumber);
    }
}
