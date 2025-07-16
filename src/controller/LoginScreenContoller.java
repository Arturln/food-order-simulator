package controller;

import exceptions.UserNotExistException;
import model.User;

public interface LoginScreenContoller {

    User logIn(String name, long phoneNumber) throws UserNotExistException;
}
