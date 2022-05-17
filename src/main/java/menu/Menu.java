package menu;

import static main.Main.output;

public class Menu {

    private static String makeChoice = "Выберите пункт меню(введите число):";

    public static void sayMakeChoice() {
        output.print(makeChoice);
    }

    //DRY используется в классах: MenuCart(строка 18),MenuCatalog(строка 19) и т.д.
    public static void printMenu(String[] menu) {
        for (var str : menu) {
            output.print(str);
        }
        output.print(makeChoice);
    }

}
