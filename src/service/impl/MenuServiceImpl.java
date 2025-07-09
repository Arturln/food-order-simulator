package service.impl;

import model.Food;
import repository.FoodRepository;
import repository.impl.FoodRepositoryImpl;
import service.MenuService;

import java.util.List;

public class MenuServiceImpl implements MenuService {

    private FoodRepository foodRepository = new FoodRepositoryImpl();

    @Override
    public List<Food> getMenu() {
        return foodRepository.getMenu();
    }
}
