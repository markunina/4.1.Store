package menu;

import input.IInput;
import users.IBuyer;

import static main.Main.*;

public class MenuWishlist {

    private static String[] menuWishlist = new String[]{
            "1. Просмотреть хотелки",
            "2. Вернуться в каталог",
            "0. Вернуться на главную страницу"
    };

    public static void getMenuWishlist(IInput input,IBuyer buyer){
        Menu.printMenu(menuWishlist);
        int inputValue = input.getNumber(0,menuWishlist.length);
        switch (inputValue){
            case 0:
                break;
            case 1:
                System.out.println(catalog.getCatalog(buyer.getWishList(), rating.getRating()));
                MenuInWishlist.getMenuInWishlist(input,buyer);
                break;
            case 2:
                MenuCatalog.getMenuCatalog(input,buyer);
                break;
        }
    }
}
