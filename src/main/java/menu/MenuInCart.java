package menu;

import input.IInput;
import users.IBuyer;

import static main.Main.*;

public class MenuInCart {
    private static String[] menuInBasket = new String[]{
            "1. Купить товары в корзине",
            "2. Удалить товар из корзины",
            "3. Вернуться в каталог",
            "0. Вернуться на главную страницу"
    };

    public static void getMenuInBasket(IInput input,IBuyer buyer){
        output.print(catalog.getCatalog(buyer.getCart(), rating.getRating()));
        Menu.printMenu(menuInBasket);
        int inputValue = input.getNumber(0,menuInBasket.length);
        switch (inputValue){
            case 0:
                break;
            case 1:
                buyer.makeOrder();
                MenuBuyer.getBuyerMenu(input,buyer);
                break;
            case 2:
                output.print("Введите id товара, который хотите удалить из корзины");
                long id = input.getId();
                if(products.getById(buyer.getCart(),id).isPresent()){
                    buyer.getCart().remove(products.getById(buyer.getCart(),id).get());
                    output.print("Товар успешно удален");
                } else {
                    output.print("Такого товара нет в корзине");
                };
                MenuCart.getMenuCart(input,buyer);
                break;
            case 3:
                MenuCatalog.getMenuCatalog(input,buyer);
                break;
        }
    }
}
