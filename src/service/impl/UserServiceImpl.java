package service.impl;

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
    public User logIn(String name, long phoneNumber) {
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
}
