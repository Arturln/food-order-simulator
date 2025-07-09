package src.repository.impl;

import src.model.Food;
import src.repository.FoodRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodRepositoryImpl implements FoodRepository {

    private List<Food> foodDataBase = new ArrayList<>(Arrays.asList(
            new Food(1, "steak T-Bone", 15.4, 340),
            new Food(2, "fish Dorado", 21, 470),
            new Food(3, "baked potato", 7.1, 210),
            new Food(4, "baked asparagus", 13.4, 180),
            new Food(5, "soup with chicken", 8.2, 560),
            new Food(6, "soup with tomatoes", 6.4, 490),
            new Food(7, "coffee", 2.3, 170),
            new Food(8, "orange juice", 3.4, 190)
    ));
    ;

    public FoodRepositoryImpl() {
    }

    @Override
    public void createFood(String name, double cost, double weight) {
        Food newFood = new Food(foodDataBase.size() + 1, name, cost, weight);
        foodDataBase.add(newFood);
    }

    @Override
    public Food readFood(int id) {
        for (Food food : foodDataBase) {
            if (food.getId() == id) {
                return food;
            }
        }
        return null;
    }

    @Override
    public void updateFood(Food food, String name, double cost, double weight) {
        foodDataBase.get(food.getId()).setName(name);
        foodDataBase.get(food.getId()).setCost(cost);
        foodDataBase.get(food.getId()).setWeight(weight);
    }


    @Override
    public void deleteFood(Food food) {
        foodDataBase.removeIf(f -> f.getId() == food.getId());
    }

    @Override
    public List<Food> getMenu() {
        return foodDataBase;
    }
}
