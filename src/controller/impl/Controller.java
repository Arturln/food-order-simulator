package controller.impl;

import controller.Controllable;
import service.MenuService;
import service.OrderService;
import service.UserService;
import service.menuServiceImpl.MenuServiceImpl;
import service.orderServiceImpl.OrderServiceImpl;
import service.userServiceImpl.UserServiceImpl;

public class Controller implements Controllable {

    public Controller() {
        UserService userService = new UserServiceImpl();
        MenuService menuService = new MenuServiceImpl();
        OrderService orderService = new OrderServiceImpl();
    }

    @Override
    public String getMenu() {
        return "";
    }

    @Override
    public void createUser(int id) {

    }

    @Override
    public String getUser(int id) {
        return "";
    }

    @Override
    public void updateUser(int id) {

    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public void createOrder(int id) {

    }

    @Override
    public void deleteOrder(int id) {

    }

    @Override
    public String getOrderInfo(int id) {
        return "";
    }

    @Override
    public void addToOrder(int orderId, int menuId) {

    }
}
