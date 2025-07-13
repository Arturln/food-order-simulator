package service;

import exceptions.ExistFoodException;
import model.Food;
import model.Order;
import model.User;

import java.util.List;

public interface OrderService {

    Order createOrder(User user, int foodID) throws ExistFoodException;

    void addFoodToOrder(Order order, int foodID) throws ExistFoodException;

    List<Food> getFoodsInOrder(Order order);

    Order readOrder(Order order);

    void deleteOrder(Order order);

    double getTotalCostInOrder(Order order);
}
