package repository.impl;

import model.Dish;
import repository.DishRepository;

import java.util.ArrayList;
import java.util.List;

public class DishRepositoryImpl implements DishRepository {

    private List<Dish> dishDataBase = new ArrayList<>();
    ;

    public DishRepositoryImpl() {
    }

    @Override
    public void createDish(String name, double cost, double weight) {
        Dish newDish = new Dish(dishDataBase.size(), name, cost, weight);
        dishDataBase.add(newDish);
    }

    @Override
    public Dish readDish(int id) {
        return dishDataBase.get(id);
    }

    @Override
    public void updateDish(Dish dish, String name, double cost, double weight) {
        dishDataBase.get(dish.getId()).setName(name);
        dishDataBase.get(dish.getId()).setCost(cost);
        dishDataBase.get(dish.getId()).setWeight(weight);
    }


    @Override
    public void deleteDish(Dish dish) {
        dishDataBase.remove(dish.getId());
    }

    @Override
    public void getMenu() {
        for (Dish dish: dishDataBase) {
            System.out.println(dish);
        }
    }
}
