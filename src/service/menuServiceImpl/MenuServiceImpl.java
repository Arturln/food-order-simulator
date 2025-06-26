package service.menuServiceImpl;

import repository.Crudable;
import repository.impl.Menu;
import service.MenuService;

public class MenuServiceImpl implements MenuService {

    public MenuServiceImpl() {
        Crudable menu = new Menu();
    }

    @Override
    public String getMenu() {
        return "";
    }
}
