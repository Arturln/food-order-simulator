package ui.impl;

import exceptions.ExistUserException;
import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import exceptions.NotExistUserException;
import model.User;
import ui.*;
import utils.ScannerUI;

public class MainMenuImpl implements MainMenuUI {

    private ScannerUI scannerUI = new ScannerUI();
    private RegisterScreen registerScreen = new RegisterScreenImpl();
    private LogInScreen logInScreen = new LogInScreenImpl();
    private int userChoice;
    private User user;

    @Override
    public void start() {

        System.out.println("Welcome to Mystery Shack\n");
        while (true) {
            System.out.println("Input:\n" +
                    "1 - to register in our restaurant\n" +
                    "2 - to logIn in our restaurant\n" +
                    "0 - to out from our Mystery Shack");
            userChoice = scannerUI.userChoice();
            switch (userChoice) {
                case Constants.REGISTER:
                    while (true) {
                        try {
                            registerScreen.registerUser();
                            break;
                        } catch (InvalidNameException e) {
                            System.out.println(e.getMessage());
                        } catch (InvalidNumberException e) {
                            System.out.println(e.getMessage());
                        } catch (ExistUserException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case Constants.LOGIN:
                    while (true) {
                        try {
                            logInScreen.logIn();
                            break;
                        } catch (InvalidNameException e) {
                            System.out.println(e.getMessage());
                        } catch (InvalidNumberException e) {
                            System.out.println(e.getMessage());
                        } catch (NotExistUserException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case Constants.LOG_OUT:
                    return;
            }
        }
    }
}
