package ui.impl;

import exceptions.UserExistException;
import exceptions.InvalidNameException;
import exceptions.InvalidNumberException;
import exceptions.UserNotExistException;
import ui.*;
import utils.ScannerUI;
import utils.WaitMessageDemonThread;

import static ui.Constants.*;

public class MainMenuImpl implements MainMenuUI {

    private ScannerUI scannerUI = new ScannerUI();
    private RegisterScreen registerScreen = new RegisterScreenImpl();
    private LogInScreen logInScreen = new LogInScreenImpl();
    private int userChoice;
    private WaitMessageDemonThread waitMessageDemonThread = new WaitMessageDemonThread();

    @Override
    public void show() {
        waitMessageDemonThread.start();
        System.out.println("Welcome to Mystery Shack\n");
        while (true) {
            System.out.println("Input:\n" +
                    "1 - to register in our restaurant\n" +
                    "2 - to logIn in our restaurant\n" +
                    "0 - to out from our Mystery Shack");
            userChoice = scannerUI.userChoice();
            switch (userChoice) {
                case REGISTER:
                    while (true) {
                        try {
                            WaitMessageDemonThread.startPrintingWaitMessage();
                            Thread.sleep(2000);
                            WaitMessageDemonThread.stopPrintingWaitMessage();
                            registerScreen.show();
                            break;
                        } catch (InvalidNameException e) {
                            System.out.println(e.getMessage());
                        } catch (InvalidNumberException e) {
                            System.out.println(e.getMessage());
                        } catch (UserExistException e) {
                            System.out.println(e.getMessage());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case LOGIN:
                    while (true) {
                        try {
                            WaitMessageDemonThread.startPrintingWaitMessage();
                            Thread.sleep(2000);
                            WaitMessageDemonThread.stopPrintingWaitMessage();
                            logInScreen.show();
                            break;
                        } catch (InvalidNameException e) {
                            System.out.println(e.getMessage());
                        } catch (InvalidNumberException e) {
                            System.out.println(e.getMessage());
                        } catch (UserNotExistException e) {
                            System.out.println(e.getMessage());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case LOG_OUT:
                    WaitMessageDemonThread.startPrintingWaitMessage();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return;
            }
        }
    }
}
