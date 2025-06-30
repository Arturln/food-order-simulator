package model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private User user;
    private Dish dish;
    private List<Dish> orderDishes;

    public Order(int id, User user, Dish dish) {
        this.id = id;
        this.user = user;
        this.dish = dish;
        this.orderDishes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public void getOrderDishes() {
        for (Dish d : orderDishes) {
            System.out.println(d);
        }
    }

    public void addDishToOrder(Dish dish) {
        orderDishes.add(dish);
    }
}
