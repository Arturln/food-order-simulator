package controller.impl;

import controller.UserController;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

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
