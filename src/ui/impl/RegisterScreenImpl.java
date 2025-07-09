package ui.impl;

import controller.UserController;
import controller.impl.UserControllerImpl;
import model.User;
import ui.RegisterScreen;
import utils.Regex;
import utils.ScannerUI;

public class RegisterScreenImpl implements RegisterScreen {

    private ScannerUI scannerUI = new ScannerUI();
    private UserController userController = new UserControllerImpl();
    private Regex regex = new Regex();

    public User registerUser() throws exceptions.InvalidNameException, exceptions.InvalidNumberException {
        System.out.println("Input your name");
        String name = regex.nameValidation(scannerUI.scanUserName());
        System.out.println("Input your phoneNumber");
        long phoneNumber = regex.phoneNumberValidation(scannerUI.scanUserPhoneNumber());
        return userController.createUser(name, phoneNumber);
    }
}
