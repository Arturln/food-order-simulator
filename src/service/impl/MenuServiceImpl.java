package service.impl;

import repository.DishRepository;
import repository.impl.DishRepositoryImpl;
import service.MenuService;

public class MenuServiceImpl implements MenuService {

    private DishRepository dishRepository = new DishRepositoryImpl();

    @Override
    public void getMenu() {
         dishRepository.getMenu();
    }
}
