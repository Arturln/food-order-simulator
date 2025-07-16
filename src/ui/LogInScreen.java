package ui;

import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import exceptions.UserNotExistException;

public interface LogInScreen {

    void show() throws InvalidNameException, InvalidNumberException, UserNotExistException;
}
