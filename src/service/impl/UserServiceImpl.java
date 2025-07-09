package src.service.impl;

import src.model.User;
import src.repository.UserRepository;
import src.repository.impl.UserRepositoryImpl;
import src.service.UserService;

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
    public User readUser(User user) {
        return userRepository.readUser(user);


    }

    @Override
    public void updateUser(User updatedUser) {
        userRepository.updateUser(updatedUser);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteUser(userRepository.readUser(user));
    }
}
