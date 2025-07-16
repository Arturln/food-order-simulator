package controller.impl;

import controller.OrderScreenController;
import exceptions.FoodExistException;
import model.Food;
import model.Order;
import model.User;
import service.FoodService;
import service.OrderService;
import service.impl.FoodServiceImpl;
import service.impl.OrderServiceImpl;
import utils.DateTime;

import java.util.List;

public class OrderScreenControllerImpl implements OrderScreenController {

    private FoodService foodService = new FoodServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    private DateTime dateTime = new DateTime();

    @Override
    public List<Food> getMenu() {
        return foodService.getFoodList();
    }

    @Override
    public Order createOrder(User user, int dishID) throws FoodExistException {
        return orderService.createOrder(user, dishID);
    }

    @Override
    public void addFoodToOrder(Order order, int foodID) throws FoodExistException {
        orderService.addFoodToOrder(order, foodID);
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
