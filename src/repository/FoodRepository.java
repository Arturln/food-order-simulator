package repository;

import model.Food;

import java.util.List;

public interface FoodRepository {

    Food create(Food food);

    Food read(int id);

    void update(Food updatedFood);

    void delete(Food food);

    List<Food> getFoodList();
}
