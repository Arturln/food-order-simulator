package ui.impl;

import controller.UserController;
import controller.impl.UserControllerImpl;
import exceptions.ExistUserException;
import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import model.User;
import ui.Constants;
import ui.RegisterScreen;
import ui.UserMenuScreen;
import utils.Regex;
import utils.ScannerUI;
import utils.WaitMessageDemonThread;

public class RegisterScreenImpl implements RegisterScreen {

    private ScannerUI scannerUI = new ScannerUI();
    private UserController userController = new UserControllerImpl();
    private UserMenuScreen userMenuScreen = new UserMenuScreenImpl();
    private Regex regex = new Regex();

    @Override
    public void registerUser() throws InvalidNameException, InvalidNumberException, ExistUserException {
        System.out.println("0 - to out from login menu\n"
                + "1 - to register user\n");
        while (true) {
            int userChoice = scannerUI.userChoice();
            switch (userChoice) {
                case Constants.OUT_FROM_REGISTER_MENU:
                    return;
                case Constants.REGISTER_SCREEN_MENU_REGISTER_USER:
                    System.out.println("Input your name");
                    String name = regex.nameValidation(scannerUI.scanUserName());
                    System.out.println("Input your phoneNumber");
                    long phoneNumber = regex.phoneNumberValidation(scannerUI.scanUserPhoneNumber());

                    User user = userController.createUser(name, phoneNumber);
                    if (user != null) {
                        System.out.println("Register is successful");
                        boolean exitMainMenu = userMenuScreen.start(user);

                        if (exitMainMenu) {
                            return;
                        }
                    }
                    break;
            }
        }
    }
}
