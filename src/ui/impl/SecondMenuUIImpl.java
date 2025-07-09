package src.ui.impl;

import src.controller.UserController;
import src.controller.impl.UserControllerImpl;
import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import src.model.User;
import src.ui.ScannerUI;
import src.ui.SecondMenuUI;
import src.ui.UpdateUserUI;
import src.utils.Constants;
import src.utils.Regex;

public class SecondMenuUIImpl implements SecondMenuUI {

    private ScannerUI scannerUI = new ScannerUIImpl();
    private UserController userController = new UserControllerImpl();
    private UpdateUserUI updateUserUI = new UpdateUserUIImpl();
    private Regex regex = new Regex();


    public User registerUser() throws InvalidNameException, InvalidNumberException {
        System.out.println("Input your name");
        String name = regex.nameValidation(scannerUI.scanUserName());
        System.out.println("Input your phoneNumber");
        long phoneNumber = regex.phoneNumberValidation(scannerUI.scanUserPhoneNumber());
        return userController.createUser(name, phoneNumber);
    }

    public User logIn() throws InvalidNameException, InvalidNumberException {
        System.out.println("Input your name");
        String name = regex.nameValidation(scannerUI.scanUserName());
        System.out.println("Input your phoneNumber");
        long phoneNumber = regex.phoneNumberValidation(scannerUI.scanUserPhoneNumber());
        return userController.logIn(name, phoneNumber);
    }

    public void updateUser(User user) throws InvalidNameException, InvalidNumberException {
        System.out.println("To change your name input 1");
        System.out.println("To change your phone number input 2");
        System.out.println("To out from changing input 0");

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
