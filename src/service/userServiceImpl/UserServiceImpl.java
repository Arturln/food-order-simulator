package service.userServiceImpl;

import repository.Crudable;
import repository.impl.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        Crudable user = new User();
    }

    @Override
    public void createUser(int id) {

    }

    @Override
    public String getUser(int id) {
        return "";
    }

    @Override
    public void updateUser(int id) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
