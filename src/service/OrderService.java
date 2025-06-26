package service;

public interface OrderService {

    void createOrder(int id);

    void deleteOrder(int id);

    String getOrderInfo(int id);

    void addToOrder(int orderId, int menuId);
}
