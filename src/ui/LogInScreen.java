package ui;

import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import exceptions.NotExistUserException;
import model.User;

public interface LogInScreen {

    void logIn() throws InvalidNameException, InvalidNumberException, NotExistUserException;
}
