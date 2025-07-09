package src.ui;

import src.model.User;

public interface UpdateUserUI {

    void updateUserPhoneNumber(User user, long phoneNumber);

    void updateUserName(User user, String name);
}
