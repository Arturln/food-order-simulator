package controller.impl;

import controller.FoodController;
import model.Food;
import service.FoodService;
import service.impl.FoodServiceImpl;

import java.util.List;

public class FoodControllerImpl implements FoodController {

    private FoodService foodService = new FoodServiceImpl();

    @Override
    public List<Food> getMenu() {
        return foodService.getFoodList();
    }
}
