package repository;

import model.Dish;
import model.Order;
import model.User;

public interface OrderRepository {

    Order createOrder(User user, Dish dish);

    void addDishToOrder(Order order, Dish dish);

    void getOrderDishes(Order order);

    Order readOrder(Order order);

    void deleteOrder(Order order);

}
