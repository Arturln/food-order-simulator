package controller.impl;

import controller.OrderController;
import model.Food;
import model.Order;
import model.User;
import service.OrderService;
import service.impl.OrderServiceImpl;
import utils.DateTime;

import java.util.List;

public class OrderControllerImpl implements OrderController {

    private OrderService orderService = new OrderServiceImpl();
    private DateTime dateTime = new DateTime();

    @Override
    public Order createOrder(User user, int dishID) {
        return orderService.createOrder(user, dishID);
    }

    @Override
    public void addFoodToOrder(Order order, int foodID) {
        orderService.addFoodToOrder(order, foodID);
    }

    @Override
    public List<Food> getFoodsInOrder(Order order) {
        return orderService.getFoodsInOrder(order);
    }

    @Override
    public void getOrderData(Order order) {
        User buffUser = order.getUser();
        System.out.println("Order number: " + order.getId());
        System.out.println(dateTime.getLocalDateTime());
        System.out.println(
                buffUser.getName() + " \n"
                        + buffUser.getPhoneNumber() + " \n"
        );
        order.getFoodsInOrder().forEach(food ->
                System.out.printf("%s, %.1f $\n",
                        food.getName(),
                        food.getCost())
        );
        System.out.printf("Total cost: %.1f $ \n", orderService.getTotalCostInOrder(order));
    }

}
