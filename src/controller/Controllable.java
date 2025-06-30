package controller;

import model.Order;
import model.User;

public interface Controllable {

    void showMenu();

    User createUser(String name, int phoneNumber);

    Order createOrder(User user, int dishID);

    void getOrderData(Order order);
}
