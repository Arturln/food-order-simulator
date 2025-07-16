package ui.impl;

import controller.RegisterScreenController;
import controller.impl.RegisterScreenControllerImpl;
import exceptions.UserExistException;
import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import model.User;
import ui.RegisterScreen;
import ui.UserMenuScreen;
import utils.Regex;
import utils.ScannerUI;
import utils.WaitMessageDemonThread;

import static ui.Constants.OUT_FROM_REGISTER_MENU;
import static ui.Constants.REGISTER_SCREEN_MENU_REGISTER_USER;

public class RegisterScreenImpl implements RegisterScreen {

    private ScannerUI scannerUI = new ScannerUI();
    private RegisterScreenController registerScreenController = new RegisterScreenControllerImpl();
    private UserMenuScreen userMenuScreen = new UserMenuScreenImpl();
    private Regex regex = new Regex();

    @Override
    public void show() throws InvalidNameException, InvalidNumberException, UserExistException {
        System.out.println("0 - to out from login menu\n"
                + "1 - to register user\n");
        while (true) {
            int userChoice = scannerUI.userChoice();
            switch (userChoice) {
                case OUT_FROM_REGISTER_MENU:
                    WaitMessageDemonThread.startPrintingWaitMessage();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    WaitMessageDemonThread.stopPrintingWaitMessage();
                    return;
                case REGISTER_SCREEN_MENU_REGISTER_USER:
                    System.out.println("Input your name");
                    String name = regex.nameValidation(scannerUI.scanUserName());
                    System.out.println("Input your phoneNumber");
                    long phoneNumber = regex.phoneNumberValidation(scannerUI.scanUserPhoneNumber());

                    User user = registerScreenController.createUser(name, phoneNumber);
                    if (user != null) {
                        WaitMessageDemonThread.startPrintingWaitMessage();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        WaitMessageDemonThread.stopPrintingWaitMessage();
                        System.out.println("Register is successful");
                        boolean exitMainMenu = userMenuScreen.show(user);
                        System.out.println(exitMainMenu);

                        if (exitMainMenu) {
                            return;
                        }
                    }
                    break;
            }
        }
    }
}
