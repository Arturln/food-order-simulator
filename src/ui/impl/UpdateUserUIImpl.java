package ui.impl;

import controller.UserController;
import controller.impl.UserControllerImpl;
import model.User;
import ui.UpdateUserUI;

public class UpdateUserUIImpl implements UpdateUserUI {

    private UserController userController = new UserControllerImpl();

    @Override
    public void updateUserPhoneNumber(User user, long phoneNumber) {
        user.setPhoneNumber(phoneNumber);
        userController.updateUser(user);
    }

    @Override
    public void updateUserName(User user, String name) {
        user.setName(name);
        userController.updateUser(user);
    }
}
