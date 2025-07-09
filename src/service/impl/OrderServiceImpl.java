package service.impl;

import model.Food;
import model.Order;
import model.User;
import repository.FoodRepository;
import repository.OrderRepository;
import repository.UserRepository;
import repository.impl.FoodRepositoryImpl;
import repository.impl.OrderRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository = new OrderRepositoryImpl();
    private FoodRepository foodRepository = new FoodRepositoryImpl();
    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public Order createOrder(User user, int foodId) {
        return orderRepository.createOrder(user, foodRepository.readFood(foodId));
    }

    @Override
    public void addFoodToOrder(Order order, int foodID) {
        orderRepository.addFoodToOrder(order, foodID);
    }

    @Override
    public List<Food> getFoodsInOrder(Order order) {
        return orderRepository.getFoodsInOrder(orderRepository.readOrder(order));
    }

    @Override
    public Order readOrder(Order order) {
        return orderRepository.readOrder(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.deleteOrder(orderRepository.readOrder(order));
    }

    @Override
    public double getTotalCostInOrder(Order order) {
        return orderRepository.readOrder(order).getFoodsInOrder().stream().mapToDouble(Food::getCost).sum();
    }
}
