package repository;

import model.User;

import java.util.List;

public interface UserRepository {

    User create(User user);

    User read(int userID);

    User getByPhoneNumber(long phoneNumber);

    void update(User updatedUser);

    void delete(int userID);

}
