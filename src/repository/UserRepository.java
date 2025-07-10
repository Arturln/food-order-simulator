package repository;

import model.User;

public interface UserRepository {

    User createUser(String name, long phoneNumber);

    User readUser(int userID);

    User logIn(String name, long phoneNumber);

    void updateUser(User updatedUser);

    void deleteUser(int userID);
}
