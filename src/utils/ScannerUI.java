package utils;

import java.util.Scanner;

public class ScannerUI {

    private Scanner scanner = new Scanner(System.in);

    public int userChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    public String scanUserName() {
        return scanner.nextLine();
    }

    public long scanUserPhoneNumber() {
        return Long.parseLong(scanner.nextLine());
    }

}
