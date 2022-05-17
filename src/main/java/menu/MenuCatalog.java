package menu;

import input.IInput;
import users.IBuyer;

import static main.Main.*;

public class MenuCatalog {

    private static String[] menuCatalog = new String[]{
            "1. Просмотреть карточку товара",
            "2. Фильтр",
            "0. Вернуться на главную страницу"
    };

    public static void getMenuCatalog(IInput input,IBuyer buyer) {
        output.print(catalog.getCatalog(getProducts, rating.getRating()));
        Menu.printMenu(menuCatalog);
        int inputValue = input.getNumber(0,menuCatalog.length);
        switch (inputValue) {
            case 0:
                break;
            case 1:
                MenuProduct.getMenuItem(input,buyer);
                break;
            case 2:
                MenuFilter.getMenuFilter(input,getProducts);
                break;
        }
    }

}
