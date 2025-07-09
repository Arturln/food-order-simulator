package controller.impl;

import controller.MenuController;
import model.Food;
import service.MenuService;
import service.impl.MenuServiceImpl;

import java.util.List;

public class MenuControllerImpl implements MenuController {

    private MenuService menuService = new MenuServiceImpl();

    @Override
    public List<Food> getMenu() {
        return menuService.getMenu();
    }
}
