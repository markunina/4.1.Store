package main;

import input.IInput;
import input.Input;
import menu.Menu;
import menu.MenuAutorization;
import menu.MenuBuyer;
import menu.MenuRegistration;
import output.IOutput;
import output.Output;
import products.*;
import seller.ISeller;
import seller.Seller;
import users.IBuyer;

import java.util.List;


public class Main {

    public static final String[] MAIN_MENU = new String[]{
            "1. Зарегистрироваться",
            "2. Авторизоваться",
            "3. Ознакомиться с каталогом",
            "0. Выйти"
    };

    public static final IInput input = new Input();
    public static final IOutput output = new Output();
    public static final IRating rating = new Rating();
    public static final ICatalog catalog = new Catalog();
    public static final IProducts products = new Products();
    public static final List<IProduct> getProducts = new Products().getProducts();
    public static final IFilter filter = new Filter();

    public static void main(String[] args) {
        ISeller seller = new Seller("ООО Конфетка");
        seller.addProduct("ириска", "(количество в кг и цена за 1кг)", 100,600,getProducts);
        seller.addProduct("сказка", "(количество в кг и цена за 1кг)", 100,300,getProducts);
        seller.addProduct("мармелад", "(количество в кг и цена за 1кг)", 100,400,getProducts);

        while (true) {
            output.print("Добро пожаловать");
            Menu.printMenu(MAIN_MENU);
            int inputValue = input.getNumber(0, MAIN_MENU.length);
            if (inputValue == 0) {
                output.print("Ждем Вас снова!");
                break;
            } else if (inputValue == 1) {
                IBuyer buyer = MenuRegistration.registration(input);
                if(buyer == null){
                    break;
                }
                MenuBuyer.getBuyerMenu(input, buyer);
            } else if (inputValue == 2) {
                while (true) {
                    IBuyer buyer = MenuAutorization.autorization(input);
                    if (buyer == null) {
                        output.print("Такого логина нет в базе.");
                        if (exitToMainMenu()) {
                            break;
                        }
                    } else {
                        MenuBuyer.getBuyerMenu(input, buyer);
                    }
                }
            } else if (inputValue == 3) {
                output.print(Main.catalog.getCatalog(Main.getProducts, rating.getRating()));
            }
        }
    }

    public static boolean exitToMainMenu() {
        String[] exitMenu = new String[]{"1. Продолжить", "0. Выйти в главное меню"};
        Menu.printMenu(exitMenu);
        int inputValue = input.getNumber(0, exitMenu.length);
        if (inputValue == 0) {
            return true;
        }
        return false;
    }
}
