package repository.impl;

import io.IO;
import io.impl.OrdersIO;
import model.Food;
import model.Order;
import model.User;
import repository.FoodRepository;
import repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private IO<Order> orderDataIO = new OrdersIO();
    private List<Order> orderDataBase = orderDataIO.readFile();
    private FoodRepository foodRepository = new FoodRepositoryImpl();

    public OrderRepositoryImpl() {
    }

    @Override
    public Order createOrder(User user, Food food) {
        if (orderDataBase == null) {
            orderDataBase = new ArrayList<>(); // Инициализация, если вдруг null
        }
        Order newOrder = new Order(user, food);
        orderDataBase.add(newOrder);
        newOrder.addFoodToOrder(food);
        orderDataIO.writeFile(orderDataBase);
        return newOrder;
    }

    @Override
    public void addFoodToOrder(Order order, int foodID) {
        order.addFoodToOrder(foodRepository.readFood(foodID));
        orderDataIO.writeFile(orderDataBase);
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
