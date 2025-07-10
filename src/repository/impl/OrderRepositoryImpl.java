package repository.impl;

import io.OrdersIO;
import model.Food;
import model.Order;
import model.User;
import repository.FoodRepository;
import repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private List<Order> orderDataBase = new ArrayList<>();
    private FoodRepository foodRepository = new FoodRepositoryImpl();

    public OrderRepositoryImpl() {
    }

    @Override
    public Order createOrder(User user, Food food) {
        Order newOrder = new Order(user, food);
        orderDataBase.add(newOrder);
        newOrder.addFoodToOrder(food);
        return newOrder;
    }

    @Override
    public void addFoodToOrder(Order order, int foodID) {
        order.addFoodToOrder(foodRepository.readFood(foodID));
    }

    @Override
    public List<Food> getFoodsInOrder(Order order) {
        return order.getFoodsInOrder();
    }

    @Override
    public Order readOrder(Order order) {
        for (Order o: orderDataBase) {
            if (o.getId() == order.getId()) {
                return o;
            }
        }
        return null;
    }

    @Override
    public void deleteOrder(Order order) {
        orderDataBase.removeIf(o -> o.getId() == order.getId());
    }
}
