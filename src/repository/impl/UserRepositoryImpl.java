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
    }

    @Override
    public User createUser(String name, long phoneNumber) {
        if (userDataBase == null) {
            userDataBase = new ArrayList<>();
        }
        User newUser = new User(name, phoneNumber);
        userDataBase.add(newUser);
        userDataIO.writeFile(userDataBase);
        return newUser;
    }

    @Override
    public User readUser(int userID) {
        for (User u : userDataBase) {
            if (u.getId() == userID) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User checkPhoneNumber(String name, long phoneNumber) {
        return userDataBase.stream()
                .filter(Objects::nonNull)
//                .filter(user -> user.getName().equals(name))
                .filter(user -> Objects.equals(user.getPhoneNumber(), phoneNumber))
                .findAny()
                .orElse(null);
    }



    @Override
    public void updateUser(User updatedUser) {
        for (int i = 0; i < userDataBase.size(); i++) {
            User currentUser = userDataBase.get(i);
            if (currentUser.getId() == updatedUser.getId()) {
                userDataBase.set(i, updatedUser);
            }
        }
        userDataIO.writeFile(userDataBase);
    }

    @Override
    public void deleteUser(int userID) {
        userDataBase.removeIf(u -> u.getId() == userID);
        userDataIO.writeFile(userDataBase);
    }

    @Override
    public boolean isEmpty() {
        return userDataBase == null;
    }
}
