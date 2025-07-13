package ui.impl;

import controller.UserController;
import controller.impl.UserControllerImpl;
import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import exceptions.NotExistUserException;
import model.User;
import ui.Constants;
import ui.LogInScreen;
import ui.UserMenuScreen;
import utils.Regex;
import utils.ScannerUI;


public class LogInScreenImpl implements LogInScreen {

    private ScannerUI scannerUI = new ScannerUI();
    private UserController userController = new UserControllerImpl();
    private UserMenuScreen userMenuScreen = new UserMenuScreenImpl();
    private Regex regex = new Regex();

    @Override
    public void logIn() throws InvalidNameException, InvalidNumberException, NotExistUserException {
        System.out.println("0 - to out from login menu\n"
                + "1 - to login user\n");
        while (true) {
            int userChoice = scannerUI.userChoice();
            switch (userChoice) {
                case Constants.OUT_FROM_LOGIN_MENU:
                    return;
                case Constants.LOGIN_SCREEN_MENU_LOGIN_USER:
                    System.out.println("Input your name");
                    String name = regex.nameValidation(scannerUI.scanUserName());
                    System.out.println("Input your phoneNumber");
                    long phoneNumber = regex.phoneNumberValidation(scannerUI.scanUserPhoneNumber());

                    User user = userController.logIn(name, phoneNumber);
                    if (user != null) {
                        System.out.println("LogIn is successful");
                        userMenuScreen.start(user);
                    }
                    break;
            }
        }
    }
}
