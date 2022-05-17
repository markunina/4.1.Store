# Решение задачи 1 (Магазин).

**Условие задачи**

**NO MAGICS**

[MenuFilter](./src/main/java/menu/MenuFilter.java), строке 45


**DRY**

метод printMenu(String[] menu) класса [Menu](./src/main/java/menu/Menu.java) используется в классах: 
1. [MenuCart](./src/main/java/menu/MenuCart.java), в строке 17,
2. [MenuCatalog](./src/main/java/menu/MenuCatalog.java), в строке 18,
3. [MenuFilter](./src/main/java/menu/MenuFilter.java), в строке 18,
4. и т.д.


**Single responsibility principle**

1. [Output](./src/main/java/output/Output.java), выполняющий одну функцию - print, имплементирующий интерфейс [IOutput](./src/main/java/output/IOutput.java)

**Open-Closed Principle**

1. класс [Buyer](./src/main/java/users/Buyer.java) наследуется от класса [User](./src/main/java/users/User.java), дополняет его, не меняя его методы.


**Liskov substitution principle**

класс [Buyer](./src/main/java/users/Buyer.java) исполняет роль [IUser](./src/main/java/users/IUser.java)(строка 17)
public class MenuRegistration


**Interface segregation principle**

класс [Product](./src/main/java/products/Product.java)  разделен на классы: 
1. [Product](./src/main/java/products/Product.java)(сам продукт),
2. [Products](./src/main/java/products/Products.java)(список продуктов магазина),
3. [Filter](./src/main/java/products/Filter.java)(фильтрация списка продуктов магазина), 
4. [Catalog](./src/main/java/products/Catalog.java)(текстовый список всех продуктов магазина), 
5. [Rating](./src/main/java/products/Rating.java)(присвоение рейтинга продуктам)

