package controller.impl;

import controller.LoginScreenContoller;
import exceptions.UserNotExistException;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class LoginScreenControllerImpl implements LoginScreenContoller {

    UserService userService = new UserServiceImpl();

    @Override
    public User logIn(String name, long phoneNumber) throws UserNotExistException {
        return userService.logIn(name, phoneNumber);
    }
}
