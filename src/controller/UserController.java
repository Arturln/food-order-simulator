package controller;

import exceptions.ExistUserException;
import exceptions.NotExistUserException;
import model.User;

public interface UserController {

    User createUser(String name, long phoneNumber) throws ExistUserException;

    void updateUser(User updatedUser);

    User logIn(String name, long phoneNumber);
}
