package service;

import model.User;

public interface UserService {

    User createUser(String name, long phoneNumber);

    User readUser(int userID);

    User checkPhoneNumber(String name, long phoneNumber);

    User logIn(String name, long phoneNumber);

    void updateUser(User updatedUser);

    void deleteUser(int userID);

    public boolean isUserDataEmpty();

}
