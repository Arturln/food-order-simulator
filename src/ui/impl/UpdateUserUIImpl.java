package ui.impl;

import controller.UpdateUserController;
import controller.impl.UpdateUserControllerImpl;
import model.User;
import ui.UpdateUserUI;

public class UpdateUserUIImpl implements UpdateUserUI {

    private UpdateUserController updateUserController = new UpdateUserControllerImpl();

    @Override
    public void updateUserPhoneNumber(User user, long phoneNumber) {
        user.setPhoneNumber(phoneNumber);
        updateUserController.updateUser(user);
    }

    @Override
    public void updateUserName(User user, String name) {
        user.setName(name);
        updateUserController.updateUser(user);
    }
}
