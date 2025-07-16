package service;

import exceptions.UserExistException;
import exceptions.UserNotExistException;
import model.User;

public interface UserService {

    User createUser(String name, long phoneNumber) throws UserExistException;

    User readUser(int userID);


    User logIn(String name, long phoneNumber) throws UserNotExistException;

    void updateUser(User updatedUser);

    void deleteUser(int userID);


}
