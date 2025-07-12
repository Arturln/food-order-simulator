package service;

import exceptions.ExistUserException;
import exceptions.NotExistUserException;
import model.User;

public interface UserService {

    User createUser(String name, long phoneNumber) throws ExistUserException;

    User readUser(int userID);


    User logIn(String name, long phoneNumber) throws NotExistUserException;

    void updateUser(User updatedUser);

    void deleteUser(int userID);


}
