package app;

import ui.MainMenuUI;
import ui.impl.MainMenuUIImpl;

public class Application {

    private MainMenuUI mainMenuUI = new MainMenuUIImpl();

    public void start() {
        mainMenuUI.start();
    }
}
