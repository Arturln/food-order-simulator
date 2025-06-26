package controller;

public interface Controllable {

    String getMenu();

    void createUser(int id);

    String getUser(int id);

    void updateUser(int id);

    void deleteUser(int id);

    void createOrder(int id);

    void deleteOrder(int id);

    String getOrderInfo(int id);

    void addToOrder(int orderId, int menuId);
}
