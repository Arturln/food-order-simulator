package controller;

import exceptions.FoodExistException;
import model.Food;
import model.Order;
import model.User;

import java.util.List;

public interface OrderController {

    Order createOrder(User user, int dishID) throws FoodExistException;

    void getOrderData(Order order);

    void addFoodToOrder(Order order, int foodID) throws FoodExistException;

    List<Food> getFoodsInOrder(Order order);

}
