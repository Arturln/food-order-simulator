package ui;

import controller.Controllable;
import controller.impl.Controller;
import model.Order;
import model.User;

import java.util.Scanner;

public class UI {

    Controllable controller = new Controller();
    Scanner scanner = new Scanner(System.in);
    private int userChoice;
    private User user;
    private Order order;


    public void startMainMenu() {

        System.out.println("Welcome to Mystery Shack\n" +
                "To LogIn in our restaurant input 1\n" +
                "If you are already registered and want to create an order input 2\n" +
                "To out from our Mystery Shack input 0");
        while (true) {
            userChoice = userChoice();
            switch (userChoice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    createOrder();
                case 0:
                    return;
            }
        }
    }

    public int userChoice() {
        return scanner.nextInt();
    }

    public String setUserName() {
        return scanner.nextLine();
    }

    public int setUserPhoneNumber() {
        return scanner.nextInt();
    }

    public void registerUser() {
        System.out.println("Input your name");
        String name = setUserName();
        System.out.println("Input your phoneNumber");
        int phoneNumber = setUserPhoneNumber();
        user = controller.createUser(name, phoneNumber);
    }

    public void createOrder() {
        while (true) {
            System.out.println("Choose dish, input number to add to order");
            System.out.println("Input 0 to finish order");
            controller.showMenu();
            userChoice = userChoice();
            order = controller.createOrder(user, userChoice);

            if (userChoice == 0) {
                System.out.println("Your order data: ");
                controller.getOrderData(order);
                return;
            }
        }
    }

}
