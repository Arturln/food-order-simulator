package repository.impl;

import io.UserDataIO;
import repository.UserRepository;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepositoryImpl implements UserRepository {

    private UserDataIO userDataIO = new UserDataIO();
    private List<User> userDataBase = userDataIO.readFile();

    public UserRepositoryImpl() {
    }

    @Override
    public User createUser(String name, long phoneNumber) {
        if (userDataBase == null) {
            userDataBase = new ArrayList<>(); // Инициализация, если вдруг null
        }
        User newUser = new User(name, phoneNumber);
//        newUser.setId(newUser.getId());
        userDataBase.add(newUser);
        userDataIO.writeFile(userDataBase);
        return newUser;
    }

    @Override
    public User readUser(User user) {
        for (User u : userDataBase) {
            if (u.getId() == user.getId()) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User logIn(String name, long phoneNumber) {
        return userDataBase.stream()
                .filter(Objects::nonNull)
                .filter(user -> name.equals(user.getName()))
                .filter(user -> user.getPhoneNumber() == phoneNumber)
                .findAny().orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void updateUser(User updatedUser) {
        for (int i = 0; i < userDataBase.size(); i++) {
            User currentUser = userDataBase.get(i);
            if (currentUser.getId() == updatedUser.getId()) {
                userDataBase.set(i, updatedUser);
            }
        }
    }

    @Override
    public void deleteUser(User user) {
        userDataBase.removeIf(u -> u.getId() == user.getId());
    }
}
