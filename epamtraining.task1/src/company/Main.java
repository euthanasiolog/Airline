package company;

import menu.Menu;
import menu.MenuHelper;

import java.io.IOException;

/**
 * Created by piatr on 17.07.18.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Menu.mainMenu();
        Menu.mainMenu(MenuHelper.getIn());
    }
}
