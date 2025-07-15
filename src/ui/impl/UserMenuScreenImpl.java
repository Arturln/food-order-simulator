package ui.impl;

import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import model.User;
import ui.*;
import utils.ScannerUI;
import utils.WaitMessageDemonThread;

public class UserMenuScreenImpl implements UserMenuScreen {

    private ScannerUI scannerUI = new ScannerUI();
    private UpdateScreen updateScreen = new UpdateScreenImpl();
    private CreateOrderUI createOrderUI = new CreateOrderScreenImpl();

    @Override
    public boolean start(User user) {

        while (true) {
            System.out.println("Input:\n" +
                    "1 - to update your profile\n" +
                    "2 - to create order\n" +
                    "0 - go to main menu");
            int userChoice = scannerUI.userChoice();
            switch (userChoice) {
                case Constants.UPDATE_USER_PROFILE:
                    try {
                        WaitMessageDemonThread.getMessage();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        WaitMessageDemonThread.stopMessage();
                        updateScreen.updateUser(user);
                    } catch (InvalidNameException e) {
                        System.out.println(e.getMessage());
                    } catch (InvalidNumberException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case Constants.CREATE_ORDER:
                    WaitMessageDemonThread.getMessage();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    WaitMessageDemonThread.stopMessage();
                    createOrderUI.createOrder(user);
                    break;
                case Constants.GO_TO_MAIN_MENU:
                    WaitMessageDemonThread.getMessage();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    WaitMessageDemonThread.stopMessage();
                    return true;
            }
        }
    }
}
