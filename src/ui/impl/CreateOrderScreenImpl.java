package ui.impl;

import controller.OrderScreenController;
import controller.impl.OrderScreenControllerImpl;
import exceptions.FoodExistException;
import model.Food;
import model.Order;
import model.User;
import ui.CreateOrderUI;
import utils.ScannerUI;
import utils.WaitMessageDemonThread;

import static ui.Constants.OUT_FROM_CHOOSING_FOOD;

public class CreateOrderScreenImpl implements CreateOrderUI {

    private OrderScreenController orderScreenController = new OrderScreenControllerImpl();
    private ScannerUI scannerUI = new ScannerUI();

    @Override
    public void show(User user) {

        try {
            System.out.println("Choose dish, input number to add to order");
            System.out.println("0 - to finish order or out from choosing food");

            for (Food food : orderScreenController.getMenu()) {
                System.out.println(food.toString());
            }

            int userChoice = scannerUI.userChoice();

            if (userChoice == OUT_FROM_CHOOSING_FOOD) {
                System.out.println("You can't create an order!");
                return;
            }

            Order order = orderScreenController.createOrder(user, userChoice);

            while (true) {

                userChoice = scannerUI.userChoice();

                if (userChoice == OUT_FROM_CHOOSING_FOOD) {
                    WaitMessageDemonThread.startPrintingWaitMessage();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    WaitMessageDemonThread.stopPrintingWaitMessage();
                    System.out.println("Your order data: ");
                    orderScreenController.getOrderData(order);
                    break;
                }

                orderScreenController.addFoodToOrder(order, userChoice);

            }
        } catch (FoodExistException e) {
            System.out.println(e.getMessage());
        }
    }
}
