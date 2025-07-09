package src.ui.impl;

import src.ui.ScannerUI;

import java.util.Scanner;

public class ScannerUIImpl implements ScannerUI {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public int userChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String scanUserName() {
        return scanner.nextLine();
    }

    @Override
    public long scanUserPhoneNumber() {
        return Long.parseLong(scanner.nextLine());
    }

    @Override
    public void cleanBuffer() {
        scanner.nextLine();
    }
}
