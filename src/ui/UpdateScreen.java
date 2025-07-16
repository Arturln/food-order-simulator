package ui;

import model.User;

public interface UpdateScreen {

    void show(User user) throws exceptions.InvalidNameException, exceptions.InvalidNumberException;
}
