package service;

import exceptions.NotExistUserException;
import model.User;

public interface UserService {

    User createUser(String name, long phoneNumber);

    User readUser(int userID);

    User checkPhoneNumber(long phoneNumber);

    User logIn(String name, long phoneNumber) throws NotExistUserException;

    void updateUser(User updatedUser);

    void deleteUser(int userID);

    public boolean isUserDataEmpty();

}
