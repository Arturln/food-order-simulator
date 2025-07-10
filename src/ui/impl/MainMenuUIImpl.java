package ui.impl;

import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import exceptions.ExistUserException;
import exceptions.NotExistUserException;
import model.Order;
import model.User;
import ui.*;
import utils.ScannerUI;

public class MainMenuUIImpl implements MainMenuUI {

    private ScannerUI scannerUI = new ScannerUI();
    private RegisterScreen registerScreen = new RegisterScreenImpl();
    private LogInScreen logInScreen = new LogInScreenImpl();
    private UpdateScreen updateScreen = new UpdateScreenImpl();
    private CreateOrderUI createOrderUI = new CreateOrderUIImpl();
    private int userChoice;
    private User user;
    private Order order;


    public void start() {

        System.out.println("Welcome to Mystery Shack\n" +
                "Input:\n" +
                "1 - to register in our restaurant\n" +
                "2 - to logIn in our restaurant\n" +
                "3 - to update your profile\n" +
                "0 - to out from our Mystery Shack");
        while (true) {
            System.out.println("Choose!");
            userChoice = scannerUI.userChoice();
            switch (userChoice) {
                case Constants.REGISTER:
                    while (true) {
                        try {
                            user = registerScreen.registerUser();
                            System.out.println("Register is successful");
                            System.out.println(user.getId() + " " + user.getName());
                            System.out.println(user.getName() + " " + user.getPhoneNumber());
                            order = createOrderUI.createOrder(user);
                            System.out.println("3 - to update your profile\n" +
                                    "0 - to out from our Mystery Shack");
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
                            user = logInScreen.logIn();
                            System.out.println("LogIn is successful");
                            order = createOrderUI.createOrder(user);
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
                case Constants.UPDATE_USER_PROFILE:
                    while (true) {
                        try {
                            updateScreen.updateUser(user);
                            break;
                        } catch (InvalidNameException e) {
                            System.out.println(e.getMessage());
                        } catch (InvalidNumberException e) {
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
