package controller.impl;

import controller.Controllable;
import model.Order;
import model.User;
import service.MenuService;
import service.OrderService;
import service.UserService;
import service.impl.MenuServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.UserServiceImpl;

public class Controller implements Controllable {

    private UserService userService = new UserServiceImpl();
    private MenuService menuService = new MenuServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

    public Controller() {
    }

    @Override
    public void showMenu() {
        menuService.getMenu();
    }

    @Override
    public User createUser(String name, int phoneNumber) {
        return userService.createUser(name, phoneNumber);
    }

    @Override
    public Order createOrder(User user, int dishID) {
        return orderService.createOrder(user, dishID);
    }

    @Override
    public void getOrderData(Order order) {
        System.out.println(
                orderService.readOrder(order).getUser().getName()
                + orderService.readOrder(order).getUser().getPhoneNumber()
                + orderService.readOrder(order).getDish()
        );
    }
    #TODO addToOrder, getOrderDIses in getOrderData
}
