package ui;

import exceptions.*;
import model.User;

public interface RegisterScreen {

    void registerUser() throws InvalidNameException, InvalidNumberException, ExistUserException;
}
