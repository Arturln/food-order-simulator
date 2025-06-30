package service.impl;

import model.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public User createUser(String name, int phoneNumber) {
        return userRepository.createUser(name, phoneNumber);
    }

    @Override
    public User readUser(User user) {
        return userRepository.readUser(user);
    }

    @Override
    public void updateUser(User user, String name, int phoneNumber) {
        userRepository.updateUser(userRepository.readUser(user), name, phoneNumber);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteUser(userRepository.readUser(user));
    }
}
