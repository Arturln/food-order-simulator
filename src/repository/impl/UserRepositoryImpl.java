package repository.impl;

import io.IO;
import io.impl.UserDataIO;
import repository.UserRepository;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepositoryImpl implements UserRepository {

    private IO<User> userDataIO = new UserDataIO();
    private List<User> userDataBase = userDataIO.readFile();

    public UserRepositoryImpl() {
        if (userDataBase == null) {
            userDataBase = new ArrayList<>();
        }
    }

    @Override
    public User create(User user) {
        userDataBase.add(user);
        userDataIO.writeFile(userDataBase);
        return user;
    }

    @Override
    public User read(int userID) {
        for (User u : userDataBase) {
            if (u.getId() == userID) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User getByPhoneNumber(long phoneNumber) {
        return userDataBase.stream()
                .filter(user -> Objects.equals(user.getPhoneNumber(), phoneNumber))
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(User updatedUser) {
        for (int i = 0; i < userDataBase.size(); i++) {
            User currentUser = userDataBase.get(i);
            if (currentUser.getId() == updatedUser.getId()) {
                userDataBase.set(i, updatedUser);
            }
        }
        userDataIO.writeFile(userDataBase);
    }

    @Override
    public void delete(int userID) {
        userDataBase.removeIf(u -> u.getId() == userID);
        userDataIO.writeFile(userDataBase);
    }

}
