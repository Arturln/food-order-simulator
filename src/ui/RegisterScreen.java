package ui;

import model.User;

public interface RegisterScreen {

    User registerUser() throws exceptions.InvalidNameException, exceptions.InvalidNumberException;
}
