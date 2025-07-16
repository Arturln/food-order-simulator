package ui.impl;

import controller.FoodController;
import controller.OrderController;
import controller.impl.FoodControllerImpl;
import controller.impl.OrderControllerImpl;
import exceptions.FoodExistException;
import model.Food;
import model.Order;
import model.User;
import ui.CreateOrderUI;
import utils.ScannerUI;
import utils.WaitMessageDemonThread;

import static ui.Constants.OUT_FROM_CHOOSING_FOOD;

public class CreateOrderScreenImpl implements CreateOrderUI {

    private FoodController foodController = new FoodControllerImpl();
    private OrderController orderController = new OrderControllerImpl();
    private ScannerUI scannerUI = new ScannerUI();

    @Override
    public void show(User user) {

        try {
            System.out.println("Choose dish, input number to add to order");
            System.out.println("0 - to finish order or out from choosing food");

            for (Food food : foodController.getMenu()) {
                System.out.println(food.toString());
            }

            int userChoice = scannerUI.userChoice();

            if (userChoice == OUT_FROM_CHOOSING_FOOD) {
                System.out.println("You can't create an order!");
                return;
            }

            Order order = orderController.createOrder(user, userChoice);

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
                    orderController.getOrderData(order);
                    break;
                }

                orderController.addFoodToOrder(order, userChoice);

            }
        } catch (FoodExistException e) {
            System.out.println(e.getMessage());
        }
    }
}
