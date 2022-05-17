package menu;

import input.IInput;
import main.Main;
import orders.IOrder;
import users.IBuyer;

import java.util.List;

import static main.Main.*;

public class MenuStatusOrder {

    private static String[] statusOrders = new String[]{
            "1. Просмотреть все заказы",
            "2. Показать, полученные заказы",
            "3. Показать товары в пути",
            "4. Показать товары, по которым осуществлен возврат",
            "0. Вернуться в главное меню"
    };

    public static void getMenuStatusOrder(IInput input,IBuyer buyer) {
        Menu.printMenu(statusOrders);
        int inputValue = input.getNumber(0, statusOrders.length);
        switch (inputValue) {
            case 0:
                break;
            case 1:
                output.print(listOrders(buyer.getOrderlist()));
                MenuBuyer.getBuyerMenu(input,buyer);
                break;
            case 2:
                var ordersIsGet = ordersIsGet(buyer.getOrderlist());
                output.print(listOrders(ordersIsGet(buyer.getOrderlist())));
                output.print("Хотите оценить полученный товар?(да/нет)");
                String str = input.getString();
                if (str.equals("да")) {
                    output.print("Введите id товара:");
                    long id = input.getId();
                    var item = ordersIsGet.stream().filter(o -> o.getProduct().getId() == id).findFirst();
                    if (item.isPresent()) {
                        System.out.println("Введите вашу оценку(число от 1 до 5");
                        int minRatingValue = 1;
                        int maxRatingValue = 5;
                        int rating = input.getNumber(minRatingValue, maxRatingValue);
                        buyer.giveReview(Main.rating.getRatings(), item.get().getProduct(), rating);
                    }
                }
                MenuBuyer.getBuyerMenu(input,buyer);
                break;
            case 3:
                output.print(listOrders(ordersIsInDelivery(buyer.getOrderlist())));
                MenuBuyer.getBuyerMenu(input,buyer);
                break;
            case 4:
                output.print(listOrders(ordersIsReturn(buyer.getOrderlist())));
                MenuBuyer.getBuyerMenu(input,buyer);
                break;
        }
    }

    public static String listOrders(List<IOrder> orders) {
        StringBuilder sB = new StringBuilder();
        for (var o : orders) {
            sB.append(o.toString()).append("\n");
        }
        return sB.toString();
    }

    public static List<IOrder> ordersIsGet(List<IOrder> orders) {
        return orders.stream().filter(o -> o.isGet()).toList();
    }

    public static List<IOrder> ordersIsInDelivery(List<IOrder> orders) {
        return orders.stream().filter(o -> o.isInDelivery()).toList();
    }

    public static List<IOrder> ordersIsReturn(List<IOrder> orders) {
        return orders.stream().filter(o -> o.isReturn()).toList();
    }

}
