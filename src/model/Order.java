package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {

    private transient Random random = new Random();

    private int id;
    private User user;
    private transient Food food;
    private List<Food> orderFoods;

    public Order(User user, Food food) {
        this.id = random.nextInt(1, 100000);
        this.user = user;
        this.food = food;
        this.orderFoods = new ArrayList<>();
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

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public List<Food> getFoodsInOrder() {
        return orderFoods;
    }

    public void addFoodToOrder(Food food) {
        orderFoods.add(food);
    }
}
