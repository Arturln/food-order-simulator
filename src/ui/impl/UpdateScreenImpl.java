package ui.impl;

import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import model.User;
import ui.Constants;
import ui.UpdateScreen;
import ui.UpdateUserUI;
import utils.Regex;
import utils.ScannerUI;
import utils.WaitMessageDemonThread;

import static ui.Constants.*;

public class UpdateScreenImpl implements UpdateScreen {

    private ScannerUI scannerUI = new ScannerUI();
    private UpdateUserUI updateUserUI = new UpdateUserUIImpl();
    private Regex regex = new Regex();

    public void show(User user) throws InvalidNameException, InvalidNumberException {
        System.out.println("1 - to change your name");
        System.out.println("2 - to change your phone number");
        System.out.println("0 - to out from changing");

        while (true) {

            int userChoice = scannerUI.userChoice();

            switch (userChoice) {
                case CHANGE_NAME:
                    System.out.println("Input new name: ");
                    String newName = regex.nameValidation(scannerUI.scanUserName());
                    updateUserUI.updateUserName(user, newName);
                    System.out.println("Updated name: " + user.getName());
                    break;
                case CHANGE_PHONE_NUMBER:
                    System.out.println("Input new phone number: ");
                    long newPhone = regex.phoneNumberValidation(scannerUI.scanUserPhoneNumber());
                    updateUserUI.updateUserPhoneNumber(user, newPhone);
                    System.out.println("Updated phone number: " + user.getPhoneNumber());
                    break;
                case OUT_FROM_CHANGING_PROFILE:
                    WaitMessageDemonThread.getMessage();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    WaitMessageDemonThread.stopMessage();
                    return;
            }
        }
    }
}
