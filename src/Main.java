package src;

import src.ui.MainMenuUI;
import src.ui.impl.MainMenuUIImpl;

public class Main {
    public static void main(String[] args) {

        MainMenuUI mainMenuUI = new MainMenuUIImpl();

        mainMenuUI.startMainMenu();

    }
}
