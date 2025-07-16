package controller.impl;

import controller.RegisterScreenController;
import exceptions.UserExistException;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class RegisterScreenControllerImpl implements RegisterScreenController {

    UserService userService = new UserServiceImpl();

    @Override
    public User createUser(String name, long phoneNumber) throws UserExistException {
        return userService.createUser(name, phoneNumber);
    }
}
