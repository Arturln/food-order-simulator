package controller.impl;

import controller.UpdateUserController;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class UpdateUserControllerImpl implements UpdateUserController {

    UserService userService = new UserServiceImpl();

    @Override
    public void updateUser(User updatedUser) {
        userService.updateUser(updatedUser);
    }
}
