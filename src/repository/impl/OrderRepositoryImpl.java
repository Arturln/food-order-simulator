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
        if (orderDataBase == null) {
            orderDataBase = new ArrayList<>();
        }
    }

    @Override
    public Order createOrder(User user, Food food) {
        Order newOrder = new Order(user, food);
        orderDataBase.add(newOrder);
        newOrder.addFoodToOrder(food);
        orderDataIO.writeFile(orderDataBase);
        return newOrder;
    }

    @Override
    public Order create(Order order) {
        orderDataBase.add(order);
        orderDataIO.writeFile(orderDataBase);
        return order;
    }

    @Override
    public void update(Order updatedOrder) {
        for (int i = 0; i < orderDataBase.size(); i++) {
            Order currentOrder = orderDataBase.get(i);
            if (currentOrder.getId() == updatedOrder.getId()) {
                orderDataBase.set(i, updatedOrder);
            }
        }
        orderDataIO.writeFile(orderDataBase);
    }

    @Override
    public List<Food> getFoods(Order order) {
        return order.getFoodsInOrder();
    }

    @Override
    public Order read(Order order) {
        for (Order o: orderDataBase) {
            if (o.getId() == order.getId()) {
                return o;
            }
        }
        return null;
    }

    @Override
    public void delete(Order order) {
        orderDataBase.removeIf(o -> o.getId() == order.getId());
    }


}
