package src.repository;

import src.model.Food;
import src.model.Order;
import src.model.User;

import java.util.List;

public interface OrderRepository {

    Order createOrder(User user, Food food);

    void addFoodToOrder(Order order, int foodID);

    List<Food> getFoodsInOrder(Order order);

    Order readOrder(Order order);

    void deleteOrder(Order order);

}
