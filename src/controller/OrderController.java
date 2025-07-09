package src.controller;

import src.model.Food;
import src.model.Order;
import src.model.User;

import java.util.List;

public interface OrderController {

    Order createOrder(User user, int dishID);

    void getOrderData(Order order);

    void addFoodToOrder(Order order, int foodID);

    List<Food> getFoodsInOrder(Order order);

}
