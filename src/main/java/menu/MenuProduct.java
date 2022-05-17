package menu;

import input.IInput;
import products.IProduct;
import users.IBuyer;

import static main.Main.*;

public class MenuProduct {

    private static String[] menuItem = new String[]{
            "1. Добавить товар в корзину",
            "2. Добавить в хотелки и вернуться в каталог",
            "3. Вернуться в каталог",
            "0. Вернуться на главную страницу"
    };

    public static void getMenuItem(IInput input, IBuyer buyer) {
        output.print("Введите id товара");
        long id = input.getId();
        IProduct product = products.getById(getProducts,id).get();
        output.print(product.toString());
        Menu.printMenu(menuItem);
        int inputValue = input.getNumber(0,menuItem.length);
        switch (inputValue) {
            case 0:
                break;
            case 1:
                buyer.addToCart(product);
                MenuCart.getMenuCart(input,buyer);
                break;
            case 2:
                buyer.addToWishList(product);
                MenuWishlist.getMenuWishlist(input,buyer);
                break;
            case 3:
                MenuCatalog.getMenuCatalog(input,buyer);
                break;
        }
    }
}
