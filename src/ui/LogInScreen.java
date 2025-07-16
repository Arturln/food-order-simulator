package ui;

import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import exceptions.NotExistUserException;

public interface LogInScreen {

    void show() throws InvalidNameException, InvalidNumberException, NotExistUserException;
}
