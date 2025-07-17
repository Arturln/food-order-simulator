package service.impl;

import exceptions.FoodExistException;
import model.Food;
import model.Order;
import model.User;
import repository.FoodRepository;
import repository.OrderRepository;
import repository.impl.FoodRepositoryImpl;
import repository.impl.OrderRepositoryImpl;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository = new OrderRepositoryImpl();
    private FoodRepository foodRepository = new FoodRepositoryImpl();

    @Override
    public Order createOrder(User user, int foodID) throws FoodExistException {
        if (foodID > foodRepository.getFoodList().size() || foodID < 1) {
            throw new FoodExistException("Food not exist");
        }
        Order order = new Order(user, foodRepository.read(foodID));
        order.addFoodToOrder(foodRepository.read(foodID));
        return orderRepository.create(order);
    }

    @Override
    public void addFoodToOrder(Order order, int foodID) throws FoodExistException {
        if (foodID > foodRepository.getFoodList().size() || foodID < 1) {
            throw new FoodExistException("Food not exist");
        }
        order.addFoodToOrder(foodRepository.read(foodID));
        orderRepository.update(order);
    }

    @Override
    public List<Food> getFoodsInOrder(Order order) {
        return orderRepository.getFoods(orderRepository.read(order));
    }

    @Override
    public Order readOrder(Order order) {
        return orderRepository.read(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(orderRepository.read(order));
    }

    @Override
    public double getTotalCostInOrder(Order order) {
        return orderRepository.read(order).getFoodsInOrder().stream().mapToDouble(Food::getCost).sum();
    }
}
