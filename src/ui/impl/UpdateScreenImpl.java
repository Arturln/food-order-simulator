package ui.impl;

import model.User;
import ui.Constants;
import ui.UpdateScreen;
import ui.UpdateUserUI;
import utils.Regex;
import utils.ScannerUI;

public class UpdateScreenImpl implements UpdateScreen {

    private ScannerUI scannerUI = new ScannerUI();
    private UpdateUserUI updateUserUI = new UpdateUserUIImpl();
    private Regex regex = new Regex();

    public void updateUser(User user) throws exceptions.InvalidNameException, exceptions.InvalidNumberException {
        System.out.println("1 - to change your name");
        System.out.println("2 - to change your phone number");
        System.out.println("0 - to out from changing");

        while (true) {

            int userChoice = scannerUI.userChoice();

            switch (userChoice) {
                case Constants.CHANGE_NAME:
                    System.out.println("Input new name: ");
                    String newName = regex.nameValidation(scannerUI.scanUserName());
                    updateUserUI.updateUserName(user, newName);
                    System.out.println("Updated name: " + user.getName());
                    break;
                case Constants.CHANGE_PHONE_NUMBER:
                    System.out.println("Input new phone number: ");
                    long newPhone = regex.phoneNumberValidation(scannerUI.scanUserPhoneNumber());
                    updateUserUI.updateUserPhoneNumber(user, newPhone);
                    System.out.println("Updated phone number: " + user.getPhoneNumber());
                    break;
                case Constants.OUT_FROM_CHANGING_PROFILE:
                    return;
            }
        }
    }
}
