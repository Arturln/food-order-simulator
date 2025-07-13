package utils;

import exceptions.InvalidNumberException;

import java.util.Scanner;

public class ScannerUI {

    private Scanner scanner = new Scanner(System.in);

    public int userChoice() throws NumberFormatException {
        while (true) {
            try {
                String userChoice = scanner.nextLine();
                return Integer.parseInt(userChoice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format");
            }

        }
    }

    public String scanUserName() {
        return scanner.nextLine();
    }

    public long scanUserPhoneNumber() {
        return Long.parseLong(scanner.nextLine());
    }

}
