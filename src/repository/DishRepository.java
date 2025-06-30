package repository;

import model.Dish;

public interface DishRepository {

    void createDish(String name, double cost, double weight);

    Dish readDish(int id);

    void updateDish(Dish dish, String name, double cost, double weight);

    void deleteDish(Dish dish);

    void getMenu();
}
