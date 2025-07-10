package controller.impl;

import controller.UserController;
import exceptions.ExistUserException;
import exceptions.NotExistUserException;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class UserControllerImpl implements UserController {

    UserService userService = new UserServiceImpl();

    @Override
    public User createUser(String name, long phoneNumber) throws ExistUserException {
        if (!userService.isUserDataEmpty()) {
            if (userService.checkPhoneNumber(phoneNumber) != null) {
                throw new ExistUserException("Can't create user with this phone number, because the phone number already exist");
            }
        }
        return userService.createUser(name, phoneNumber);
    }

    @Override
    public void updateUser(User updatedUser) {
        userService.updateUser(updatedUser);
    }

    @Override
    public User logIn(String name, long phoneNumber) throws NotExistUserException {
        return userService.logIn(name, phoneNumber);
    }
}
