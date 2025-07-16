package controller;

import exceptions.UserExistException;
import model.User;

public interface RegisterScreenController {

    User createUser(String name, long phoneNumber) throws UserExistException;
}
