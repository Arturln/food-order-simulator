package ui;

import exceptions.*;
import model.User;

public interface RegisterScreen {

    User registerUser() throws InvalidNameException, InvalidNumberException, ExistUserException;
}
