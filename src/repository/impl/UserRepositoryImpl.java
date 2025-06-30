package repository.impl;

import repository.UserRepository;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private List<User> userDataBase = new ArrayList<>();

    public UserRepositoryImpl() {
    }

    @Override
    public User createUser(String name, int phoneNumber) {
        User newUser = new User(userDataBase.size(), name, phoneNumber);
        userDataBase.add(newUser);
        return newUser;
    }

    @Override
    public User readUser(User user) {
        return userDataBase.get(user.getId());
    }

    @Override
    public void updateUser(User user, String name, int phoneNumber) {
        userDataBase.get(user.getId()).setName(name);
        userDataBase.get(user.getId()).setPhoneNumber(phoneNumber);
    }

    @Override
    public void deleteUser(User user) {
        userDataBase.remove(user.getId());
    }
}
