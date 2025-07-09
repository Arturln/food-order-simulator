package src.ui.impl;

import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import src.model.Order;
import src.model.User;
import src.ui.CreateOrderUI;
import src.ui.ScannerUI;
import src.ui.SecondMenuUI;
import src.ui.MainMenuUI;
import src.utils.Constants;

public class MainMenuUIImpl implements MainMenuUI {

    private ScannerUI scannerUI = new ScannerUIImpl();
    private SecondMenuUI secondMenuUI = new SecondMenuUIImpl();
    private CreateOrderUI createOrderUI = new CreateOrderUIImpl();
    private int userChoice;
    private User user;
    private Order order;


    @Override
    public void startMainMenu() {

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
                            user = secondMenuUI.registerUser();
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
                            user = secondMenuUI.logIn();
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
                            secondMenuUI.updateUser(user);
                            break;
                        } catch (InvalidNameException e) {
                            System.out.println(e.getMessage());
                        } catch (InvalidNumberException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case Constants.OUT_FROM_RESTAURANT:
                    return;
            }
        }
    }
}
