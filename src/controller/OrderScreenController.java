package controller;

import exceptions.FoodExistException;
import model.Food;
import model.Order;
import model.User;

import java.util.List;

public interface OrderScreenController {

    List<Food> getMenu();

    Order createOrder(User user, int dishID) throws FoodExistException;

    void getOrderData(Order order);

    void addFoodToOrder(Order order, int foodID) throws FoodExistException;
}
