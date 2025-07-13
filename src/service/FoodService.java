package service;

import model.Food;

import java.util.List;

public interface FoodService {

    List<Food> getFoodList();

    Food createFood(String name, double cost, double weight);

    void update(Food updatedFood);

    void delete(Food food);

}
