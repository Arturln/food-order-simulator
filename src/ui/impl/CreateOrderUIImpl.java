package ui.impl;

import controller.MenuController;
import controller.OrderController;
import controller.impl.MenuControllerImpl;
import controller.impl.OrderControllerImpl;
import model.Food;
import model.Order;
import model.User;
import ui.CreateOrderUI;
import ui.Constants;
import utils.ScannerUI;

public class CreateOrderUIImpl implements CreateOrderUI {

    private MenuController menuController = new MenuControllerImpl();
    private OrderController orderController = new OrderControllerImpl();
    private ScannerUI scannerUI = new ScannerUI();

    @Override
    public Order createOrder(User user) {

        System.out.println("Choose dish, input number to add to order");
        System.out.println("0 - to finish order or out from choosing food");

        for (Food food : menuController.getMenu()) {
            System.out.println(food.toString());
        }

        int userChoice = scannerUI.userChoice();

        if (userChoice == Constants.OUT_FROM_CHOOSING_FOOD) {
            System.out.println("You can't create an order!");
            return null;
        }

        Order order = orderController.createOrder(user, userChoice);

        while (true) {

            userChoice = scannerUI.userChoice();

            if (userChoice == Constants.OUT_FROM_CHOOSING_FOOD) {
                System.out.println("Your order data: ");
                orderController.getOrderData(order);
                break;
            }

            orderController.addFoodToOrder(order, userChoice);
        }
        return order;
    }
}
