package repository.impl;

import io.impl.FoodDataIO;
import io.IO;
import model.Food;
import repository.FoodRepository;

import java.util.List;

public class FoodRepositoryImpl implements FoodRepository {

    private IO<Food> foodDataIO = new FoodDataIO();
    private List<Food> foodDataBase = foodDataIO.readFile();
//    private List<Food> foodDataBase = new ArrayList<>(Arrays.asList(
//            new Food(1, "steak T-Bone", 15.4, 340),
//            new Food(2, "fish Dorado", 21, 470),
//            new Food(3, "baked potato", 7.1, 210),
//            new Food(4, "baked asparagus", 13.4, 180),
//            new Food(5, "soup with chicken", 8.2, 560),
//            new Food(6, "soup with tomatoes", 6.4, 490),
//            new Food(7, "coffee", 2.3, 170),
//            new Food(8, "orange juice", 3.4, 190)
//    ));


    public FoodRepositoryImpl() {

    }

    @Override
    public void createFood(String name, double cost, double weight) {
        Food newFood = new Food(foodDataBase.size() + 1, name, cost, weight);
        foodDataBase.add(newFood);
        foodDataIO.writeFile(foodDataBase);
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
    public void updateFood(Food updetedFood) {
        for (int i = 0; i < foodDataBase.size(); i++) {
            Food currentFood = foodDataBase.get(i);
            if (currentFood.getId() == updetedFood.getId()) {
                foodDataBase.set(i, updetedFood);
            }
        }
        foodDataIO.writeFile(foodDataBase);
    }


    @Override
    public void deleteFood(Food food) {
        foodDataBase.removeIf(f -> f.getId() == food.getId());
        foodDataIO.writeFile(foodDataBase);
    }

    @Override
    public List<Food> getMenu() {
        return foodDataBase;
    }
}
