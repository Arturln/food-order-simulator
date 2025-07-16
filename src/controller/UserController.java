package controller;

import exceptions.UserExistException;
import exceptions.UserNotExistException;
import model.User;

public interface UserController {

    User createUser(String name, long phoneNumber) throws UserExistException;

    void updateUser(User updatedUser);

    User logIn(String name, long phoneNumber) throws UserNotExistException;
}
