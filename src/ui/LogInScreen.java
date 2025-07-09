package ui;

import model.User;

public interface LogInScreen {

    User logIn() throws exceptions.InvalidNameException, exceptions.InvalidNumberException;
}
