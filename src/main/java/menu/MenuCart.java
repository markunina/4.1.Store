package menu;

import input.IInput;
import users.IBuyer;

import static main.Main.*;

public class MenuCart {

    private static String[] menuBasket = new String[]{
            "1. Перейти в корзину",
            "2. Вернуться к списку товаров",
            "0. Вернуться на главную страницу"
    };

    public static void getMenuCart(IInput input,IBuyer buyer) {
        Menu.printMenu(menuBasket);//DRY
        int inputValue = input.getNumber(0,menuBasket.length);
        switch (inputValue) {
            case 0:
                break;
            case 1:
                var list = buyer.getCart();
                MenuInCart.getMenuInBasket(input,buyer);
                break;
            case 2:
                MenuCatalog.getMenuCatalog(input,buyer);
                break;
        }
    }
}
