package ui.impl;

import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import model.Order;
import model.User;
import ui.*;

public class MainMenuUIImpl implements MainMenuUI {

    private ScannerUI scannerUI = new ScannerUIImpl();
    private RegisterScreen registerScreen = new RegisterScreenImpl();
    private LogInScreen logInScreen = new LogInScreenImpl();
    private UpdateScreen updateScreen = new UpdateScreenImpl();
    private CreateOrderUI createOrderUI = new CreateOrderUIImpl();
    private int userChoice;
    private User user;
    private Order order;


    public void start() {

        System.out.println("Welcome to Mystery Shack\n" +
                "To register in our restaurant input 1\n" +
                "To LogIn in our restaurant input 2\n" +
                "If you want to update your profile input 3\n" +
                "To out from our Mystery Shack input 0");
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
                            break;
                        } catch (InvalidNameException e) {
                            System.out.println(e.getMessage());
                        } catch (InvalidNumberException e) {
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
