package repository;

import model.User;

public interface UserRepository {

    User createUser(String name, int phoneNumber);

    User readUser(User user);

    void updateUser(User user, String name, int phoneNumber);

    void deleteUser(User user);
}
