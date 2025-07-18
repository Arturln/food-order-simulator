package ui.impl;

import controller.LoginScreenContoller;
import controller.impl.LoginScreenControllerImpl;
import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import exceptions.UserNotExistException;
import model.User;
import ui.LogInScreen;
import ui.UserMenuScreen;
import utils.Regex;
import utils.ScannerUI;
import utils.WaitMessageDemonThread;

import static ui.Constants.LOGIN_SCREEN_MENU_LOGIN_USER;
import static ui.Constants.OUT_FROM_LOGIN_MENU;


public class LogInScreenImpl implements LogInScreen {

    private ScannerUI scannerUI = new ScannerUI();
    private LoginScreenContoller loginScreenController = new LoginScreenControllerImpl();
    private UserMenuScreen userMenuScreen = new UserMenuScreenImpl();
    private Regex regex = new Regex();

    @Override
    public void show() throws InvalidNameException, InvalidNumberException, UserNotExistException {
        System.out.println("0 - to out from login menu\n"
                + "1 - to login user\n");
        while (true) {
            int userChoice = scannerUI.userChoice();
            switch (userChoice) {
                case OUT_FROM_LOGIN_MENU:
                    WaitMessageDemonThread.startPrintingWaitMessage();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    WaitMessageDemonThread.stopPrintingWaitMessage();
                    return;
                case LOGIN_SCREEN_MENU_LOGIN_USER:
                    System.out.println("Input your name");
                    String name = regex.nameValidation(scannerUI.scanUserName());
                    System.out.println("Input your phoneNumber");
                    long phoneNumber = regex.phoneNumberValidation(scannerUI.scanUserPhoneNumber());

                    User user = loginScreenController.logIn(name, phoneNumber);
                    if (user != null) {
                        WaitMessageDemonThread.startPrintingWaitMessage();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        WaitMessageDemonThread.stopPrintingWaitMessage();
                        System.out.println("LogIn is successful");
                        boolean exitMeinMenu = userMenuScreen.show(user);

                        if (exitMeinMenu) {
                            return;
                        }
                    }
                    break;
            }
        }
    }
}
