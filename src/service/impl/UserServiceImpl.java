package service.impl;

import exceptions.NotExistUserException;
import model.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public User createUser(String name, long phoneNumber) {
        return userRepository.createUser(name, phoneNumber);
    }

    @Override
    public User checkPhoneNumber(long phoneNumber) throws NotExistUserException {
        return userRepository.checkPhoneNumber(phoneNumber);
    }

    @Override
    public User logIn(String name, long phoneNumber) throws NotExistUserException {
        if (userRepository.logIn(name, phoneNumber) == null) {
            throw new NotExistUserException("User doesn't exist");
        }
        return userRepository.logIn(name, phoneNumber);
    }

    @Override
    public User readUser(int userID) {
        return userRepository.readUser(userID);


    }

    @Override
    public void updateUser(User updatedUser) {
        userRepository.updateUser(updatedUser);
    }

    @Override
    public void deleteUser(int userID) {
        userRepository.deleteUser(userID);
    }

    @Override
    public boolean isUserDataEmpty() {
        return userRepository.isEmpty();
    }
}
