package repository;

import model.Food;
import model.Order;
import model.User;

import java.util.List;

public interface OrderRepository {

    Order createOrder(User user, Food food);

    Order create(Order order);

    void addFood(Order order, int foodID);

    List<Food> getFoods(Order order);

    Order read(Order order);

    void delete(Order order);

}
