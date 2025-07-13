package service.impl;

import model.Food;
import repository.FoodRepository;
import repository.impl.FoodRepositoryImpl;
import service.FoodService;

import java.util.List;

public class FoodServiceImpl implements FoodService {

    private FoodRepository foodRepository = new FoodRepositoryImpl();

    @Override
    public List<Food> getFoodList() {
        return foodRepository.getFoodList();
    }

    @Override
    public Food createFood(String name, double cost, double weight) {
        Food food = new Food(foodRepository.getFoodList().size() + 1, name, cost, weight);
        return foodRepository.create(food);
    }

    @Override
    public void update(Food updatedFood) {
        foodRepository.update(updatedFood);
    }

    @Override
    public void delete(Food food) {
        foodRepository.delete(food);
    }
}
