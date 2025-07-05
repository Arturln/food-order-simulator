package controller;

import model.User;

public interface UserController {

    User createUser(String name, long phoneNumber);

    void updateUser(User updatedUser);

    User logIn(String name, long phoneNumber);
}
