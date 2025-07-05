package src;

import ui.MainMenuUI;
import ui.impl.MainMenuUIImpl;

public class Main {
    public static void main(String[] args) {

        MainMenuUI mainMenuUI = new MainMenuUIImpl();

        mainMenuUI.startMainMenu();

    }
}
