package src.ui;

import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import src.model.User;

public interface SecondMenuUI {

    User registerUser() throws InvalidNameException, InvalidNumberException;

    User logIn() throws InvalidNameException, InvalidNumberException;

    void updateUser(User user) throws InvalidNameException, InvalidNumberException;
}
