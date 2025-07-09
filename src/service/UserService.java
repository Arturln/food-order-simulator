package src.service;

import src.model.User;

public interface UserService {

    User createUser(String name, long phoneNumber);

    User readUser(User user);

    User logIn(String name, long phoneNumber);

    void updateUser(User updatedUser);

    void deleteUser(User user);

}
