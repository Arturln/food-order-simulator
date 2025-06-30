package service.impl;

import model.Dish;
import model.Order;
import model.User;
import repository.DishRepository;
import repository.OrderRepository;
import repository.UserRepository;
import repository.impl.DishRepositoryImpl;
import repository.impl.OrderRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import service.OrderService;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository = new OrderRepositoryImpl();
    private DishRepository dishRepository = new DishRepositoryImpl();
    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public Order createOrder(User user, int dishId) {
        return orderRepository.createOrder(userRepository.readUser(user), dishRepository.readDish(dishId));
    }

    @Override
    public void addDishToOrder(Order order, int dishID) {
        orderRepository.addDishToOrder(orderRepository.readOrder(order), dishRepository.readDish(dishID));
    }

    @Override
    public void getOrderDishes(Order order) {
        orderRepository.getOrderDishes(orderRepository.readOrder(order));
    }

    @Override
    public Order readOrder(Order order) {
        return orderRepository.readOrder(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.deleteOrder(orderRepository.readOrder(order));
    }
}
