package ui;

import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import exceptions.NotExistUserException;
import model.User;

public interface LogInScreen {

    User logIn() throws InvalidNameException, InvalidNumberException, NotExistUserException;
}
