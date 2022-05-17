package menu;

import input.IInput;
import products.IProduct;

import java.util.List;

import static main.Main.*;

//NO MAGICS в строке 45
public class MenuFilter {

    private static String[] menuFilter = new String[]{
            "1. Фильтр по наименованию",
            "2. Фильтр по тексту",
            "3. Фильтр по цене",
            "4. В наличии",
            "0. Вернуться в главное меню"
    };

    public static void getMenuFilter(IInput input, List<IProduct> products){
        Menu.printMenu(menuFilter);
        int inputValue = input.getNumber(0,menuFilter.length);
        switch (inputValue){
            case 0:
                break;
            case 1:
                output.print("Введите текст для поиска в наименовании:");
                String text = input.getString();
                var list = filter.filterByName(text,products);
                output.print(catalog.getCatalog(list, rating.getRating()));
                getMenuFilter(input,list);
                break;
            case 2:
                output.print("Введите текст для поиска:");
                text = input.getString();
                list = filter.filterByAll(text,products);
                output.print(catalog.getCatalog(list, rating.getRating()));
                getMenuFilter(input,list);
                break;
            case 3:
                output.print("Введите минимальную стоимость:");
                double minValue = input.getPrice(0,Double.MAX_VALUE);
                output.print("Введите максимальную стоимость:");
                double maxValue = input.getPrice(0,Double.MAX_VALUE);
                list = filter.filterByPrice(minValue,maxValue,products);//no magics
                output.print(catalog.getCatalog(list, rating.getRating()));
                getMenuFilter(input,list);
                break;
            case 4:
                list = filter.filterAvailable(products);
                output.print(catalog.getCatalog(list, rating.getRating()));
                getMenuFilter(input,list);
                break;
        }
    }

}
