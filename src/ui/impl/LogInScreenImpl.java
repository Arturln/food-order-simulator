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
import utils.WaitMessageDemonThread;

import static ui.Constants.LOGIN_SCREEN_MENU_LOGIN_USER;
import static ui.Constants.OUT_FROM_LOGIN_MENU;


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
                case OUT_FROM_LOGIN_MENU:
                    WaitMessageDemonThread.getMessage();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    WaitMessageDemonThread.stopMessage();
                    return;
                case LOGIN_SCREEN_MENU_LOGIN_USER:
                    System.out.println("Input your name");
                    String name = regex.nameValidation(scannerUI.scanUserName());
                    System.out.println("Input your phoneNumber");
                    long phoneNumber = regex.phoneNumberValidation(scannerUI.scanUserPhoneNumber());

                    User user = userController.logIn(name, phoneNumber);
                    if (user != null) {
                        WaitMessageDemonThread.getMessage();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        WaitMessageDemonThread.stopMessage();
                        System.out.println("LogIn is successful");
                        boolean exitMeinMenu = userMenuScreen.start(user);

                        if (exitMeinMenu) {
                            return;
                        }
                    }
                    break;
            }
        }
    }
}
