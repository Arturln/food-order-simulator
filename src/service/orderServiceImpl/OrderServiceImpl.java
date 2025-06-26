package service.orderServiceImpl;

import repository.Crudable;
import repository.impl.Order;
import service.OrderService;

public class OrderServiceImpl implements OrderService {

    public OrderServiceImpl() {
        Crudable order = new Order();
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
