package repository.impl;

import model.Dish;
import model.Order;
import model.User;
import repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private List<Order> orderDataBase = new ArrayList<>();
    ;

    public OrderRepositoryImpl() {
    }

    @Override
    public Order createOrder(User user, Dish dish) {
        Order newOrder = new Order(orderDataBase.size(), user, dish);
        orderDataBase.add(newOrder);
        newOrder.addDishToOrder(dish);
        return newOrder;
    }

    @Override
    public void addDishToOrder(Order order, Dish dish) {
        order.addDishToOrder(dish);
    }

    @Override
    public void getOrderDishes(Order order) {
        order.getOrderDishes();
    }

    @Override
    public Order readOrder(Order order) {
        return orderDataBase.get(order.getId());
    }

    @Override
    public void deleteOrder(Order order) {
        orderDataBase.remove(order.getId());
    }
}
