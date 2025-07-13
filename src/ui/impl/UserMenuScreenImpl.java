package ui.impl;

import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import model.User;
import ui.*;
import utils.ScannerUI;

public class UserMenuScreenImpl implements UserMenuScreen {

    private ScannerUI scannerUI = new ScannerUI();
    private UpdateScreen updateScreen = new UpdateScreenImpl();
    private CreateOrderUI createOrderUI = new CreateOrderScreenImpl();
//    private MainMenuUI mainMenuUI = new MainMenuImplREMASTER();

    @Override
    public void start(User user) {

        while (true) {
            System.out.println("Input:\n" +
                    "1 - to update your profile\n" +
                    "2 - to create order\n" +
                    "0 - go to main menu");
            int userChoice = scannerUI.userChoice();
            switch (userChoice) {
                case Constants.UPDATE_USER_PROFILE:
                    try {
                        updateScreen.updateUser(user);
                    } catch (InvalidNameException e) {
                        System.out.println(e.getMessage());
                    } catch (InvalidNumberException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case Constants.CREATE_ORDER:
                    createOrderUI.createOrder(user);
                    break;
                case Constants.GO_TO_MAIN_MENU:
//                    mainMenuUI.start();
//                    break;
                    return;
            }
        }
    }
}
