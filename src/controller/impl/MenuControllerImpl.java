package src.controller.impl;

import src.controller.MenuController;
import src.model.Food;
import src.service.MenuService;
import src.service.impl.MenuServiceImpl;

import java.util.List;

public class MenuControllerImpl implements MenuController {

    private MenuService menuService = new MenuServiceImpl();

    @Override
    public List<Food> getMenu() {
        return menuService.getMenu();
    }
}
