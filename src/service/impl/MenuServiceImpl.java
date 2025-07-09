package src.service.impl;

import src.model.Food;
import src.repository.FoodRepository;
import src.repository.impl.FoodRepositoryImpl;
import src.service.MenuService;

import java.util.List;

public class MenuServiceImpl implements MenuService {

    private FoodRepository foodRepository = new FoodRepositoryImpl();

    @Override
    public List<Food> getMenu() {
        return foodRepository.getMenu();
    }
}
