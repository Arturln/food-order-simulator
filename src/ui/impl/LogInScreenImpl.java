package ui.impl;

import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import exceptions.NotExistUserException;
import controller.UserController;
import controller.impl.UserControllerImpl;
import model.User;
import ui.LogInScreen;
import utils.Regex;
import utils.ScannerUI;

public class LogInScreenImpl implements LogInScreen {

    private ScannerUI scannerUI = new ScannerUI();
    private UserController userController = new UserControllerImpl();
    private Regex regex = new Regex();

    public User logIn() throws InvalidNameException, InvalidNumberException, NotExistUserException {
        System.out.println("Input your name");
        String name = regex.nameValidation(scannerUI.scanUserName());
        System.out.println("Input your phoneNumber");
        long phoneNumber = regex.phoneNumberValidation(scannerUI.scanUserPhoneNumber());
        return userController.logIn(name, phoneNumber);
    }
}
