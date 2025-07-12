package service.impl;

import exceptions.ExistUserException;
import exceptions.NotExistUserException;
import model.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public User createUser(String name, long phoneNumber) throws ExistUserException {
        User user = userRepository.getByPhoneNumber(phoneNumber);
        if (user == null) {
            user = new User(name, phoneNumber);
        } else {
            throw new ExistUserException("Can't create user with this phone number, because the phone number already exist");
        }
        return userRepository.create(user);
    }


    @Override
    public User logIn(String name, long phoneNumber) throws NotExistUserException {
        if (userRepository.getByNameAndPhone(name, phoneNumber) == null) {
            throw new NotExistUserException("User doesn't exist");
        }
        return userRepository.getByNameAndPhone(name, phoneNumber);
    }

    @Override
    public User readUser(int userID) {
        return userRepository.read(userID);


    }

    @Override
    public void updateUser(User updatedUser) {
        userRepository.update(updatedUser);
    }

    @Override
    public void deleteUser(int userID) {
        userRepository.delete(userID);
    }

}
