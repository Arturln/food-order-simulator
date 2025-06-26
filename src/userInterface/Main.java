package userInterface;

import controller.Controllable;
import controller.impl.Controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controllable controller = new Controller();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Mystery Shack\n" +
                "To LogIn in our restaurant input 1\n" +
                "If you are already registered and want to create an order input 2\n" +
                "To out from our Mystery Shack input 0");
        int numberInt;
        String userPhone, userName;
        int dishNumber;
        while (true) {
            numberInt = scanner.nextInt();

            switch (numberInt) {
                case 1:
                    System.out.println("Input your name");
                    userName = scanner.nextLine();
                    System.out.println("Input your name");
                    userPhone = scanner.nextLine();
                    break;
                case 2:
                    while (true) {
                        System.out.println("Choose dish, input number to add to order");
                        controller.getMenu();
                        System.out.println("Input 0 to finish order");
                        dishNumber = scanner.nextInt();
                        controller.createOrder(dishNumber);
                        if (dishNumber == 0) {
                            break;
                        }
                    }
                    break;
            }
            if (numberInt == 0) {
                break;
            }
        }
    }
}
