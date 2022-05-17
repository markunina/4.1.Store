package menu;

import input.IInput;
import users.IBuyer;

public class MenuBuyer {
    private static String[] buyerMenu = new String[]{
            "1. Каталог",
            "2. Хотелки",
            "3. Корзина",
            "4. Статус заказов",
            "0. Вернуться в главное меню"
    };

    public static void getBuyerMenu(IInput input,IBuyer buyer) {
        Menu.printMenu(buyerMenu);//DRY
        int inputValue = input.getNumber(0,buyerMenu.length);
        switch (inputValue) {
            case 0:
                break;
            case 1:
                MenuCatalog.getMenuCatalog(input,buyer);
                break;
            case 2:
                MenuInWishlist.getMenuInWishlist(input,buyer);
                break;
            case 3:
                MenuInCart.getMenuInBasket(input,buyer);
                break;
            case 4:
                MenuStatusOrder.getMenuStatusOrder(input,buyer);
                break;
        }
    }

}
