package ui;

import model.User;

public interface UpdateScreen {

    void updateUser(User user) throws exceptions.InvalidNameException, exceptions.InvalidNumberException;
}
