package ui;

import exceptions.*;

public interface RegisterScreen {

    void show() throws InvalidNameException, InvalidNumberException, UserExistException;
}
