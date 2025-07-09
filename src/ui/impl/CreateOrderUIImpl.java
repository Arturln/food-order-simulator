package src.ui.impl;

import src.controller.MenuController;
import src.controller.OrderController;
import src.controller.impl.MenuControllerImpl;
import src.controller.impl.OrderControllerImpl;
import src.model.Food;
import src.model.Order;
import src.model.User;
import src.ui.CreateOrderUI;
import src.ui.ScannerUI;
import src.utils.Constants;

public class CreateOrderUIImpl implements CreateOrderUI {

    private MenuController menuController = new MenuControllerImpl();
    private OrderController orderController = new OrderControllerImpl();
    private ScannerUI scannerUI = new ScannerUIImpl();

    @Override
    public Order createOrder(User user) {

        System.out.println("Choose dish, input number to add to order");
        System.out.println("Input 0 to finish order or out from choosing food");

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
