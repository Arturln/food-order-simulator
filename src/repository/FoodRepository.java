package repository;

import model.Food;

import java.util.List;

public interface FoodRepository {

    void createFood(String name, double cost, double weight);

    Food readFood(int id);

    void updateFood(Food updatedFood);

    void deleteFood(Food food);

    List<Food> getMenu();
}
