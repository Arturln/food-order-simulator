package src.service;

import src.model.Food;
import src.model.Order;
import src.model.User;

import java.util.List;

public interface OrderService {

    Order createOrder(User user, int foodId);

    void addFoodToOrder(Order order, int foodID);

    List<Food> getFoodsInOrder(Order order);

    Order readOrder(Order order);

    void deleteOrder(Order order);

    double getTotalCostInOrder(Order order);
}
