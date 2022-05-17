package menu;

import input.IInput;
import products.IProduct;
import users.IBuyer;

import static main.Main.*;

public class MenuInWishlist {
    private static String[] menuInWishlist = new String[]{
            "1. Удалить из хотелок",
            "2. Добавить в корзину",
            "3. Вернуться в каталог",
            "0. Выйти"
    };

    public static void getMenuInWishlist(IInput input,IBuyer buyer){
        output.print(catalog.getCatalog(buyer.getWishList(), rating.getRating()));
        Menu.printMenu(menuInWishlist);
        int inputValue = input.getNumber(0,menuInWishlist.length);
        switch (inputValue){
            case 0:
                break;
            case 1:
                output.print("Введите id товара, который хотите удалить:");
                long id = input.getId();
                IProduct product = products.getById(getProducts,id).get();
                if(buyer.removeFromCart(product)){
                    output.print("Товар удален из списка");
                } else {
                    output.print("Такого товара нет в списке");
                }
                break;
            case 2:
                output.print("Введите id товара, который хотите переместить в корзину:");
                id = input.getId();
                product = products.getById(buyer.getCart(),id).get();
                if(buyer.getCart().contains(product)) {
                    buyer.addToCart(product);
                    MenuCart.getMenuCart(input, buyer);
                } else {
                    output.print("Такого товара нет в хотелках");
                }
                break;
            case 3:
                MenuCatalog.getMenuCatalog(input,buyer);
                break;
        }
    }
}
