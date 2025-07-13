package controller;

import exceptions.ExistFoodException;
import model.Food;
import model.Order;
import model.User;

import java.util.List;

public interface OrderController {

    Order createOrder(User user, int dishID) throws ExistFoodException;

    void getOrderData(Order order);

    void addFoodToOrder(Order order, int foodID) throws ExistFoodException;

    List<Food> getFoodsInOrder(Order order);

}
